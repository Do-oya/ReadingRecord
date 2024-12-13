package toby.springbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import toby.springbook.user.dao.DaoFactory;
import toby.springbook.user.domain.Level;
import toby.springbook.user.domain.User;
import toby.springbook.user.domain.UserDaoJdbc;
import toby.springbook.user.service.UserService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static toby.springbook.user.service.UserService.MIN_LOGCOUNT_FOR_SLIVER;
import static toby.springbook.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class UserServiceTest {
    @Autowired private UserService userService;
    @Autowired private UserDaoJdbc userDao;

    List<User> users;

    @BeforeEach
    public void setUp() {
        users = Arrays.asList(
                new User("test1", "test1", "test1", Level.BASIC, MIN_LOGCOUNT_FOR_SLIVER-1, 0),
                new User("test2", "test2", "test2", Level.BASIC, MIN_LOGCOUNT_FOR_SLIVER, 0),
                new User("test3", "test3", "test3", Level.SILVER, MIN_RECCOMEND_FOR_GOLD-1, 29),
                new User("test4", "test4", "test4", Level.SILVER, MIN_RECCOMEND_FOR_GOLD, 30),
                new User("test5", "test5", "test5", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    public void upgradeLevels() {
        userDao.deleteAll();
        for(User user : users) userDao.add(user);

        userService.upgradeLevels();

        checkLevelUpgraded(users.get(0), false);
        checkLevelUpgraded(users.get(1), true);
        checkLevelUpgraded(users.get(2), false);
        checkLevelUpgraded(users.get(3), true);
        checkLevelUpgraded(users.get(4), false);
    }

    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.getId());
        if (upgraded) {
            assertThat(userUpdate.getLevel()).isEqualTo(user.getLevel().nextLevel());
        }
        else {
            assertThat(userUpdate.getLevel()).isEqualTo(user.getLevel());
        }
    }

    @Test
    public void add() {
        userDao.deleteAll();

        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

        assertThat(userWithLevelRead.getLevel()).isEqualTo(userWithLevelRead.getLevel());
        assertThat(userWithoutLevelRead.getLevel()).isEqualTo(Level.BASIC);
    }

}
