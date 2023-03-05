import java.net.URI;
import java.util.List;

public class MyHttpTest {

    public static final String USERS = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {

        System.out.println("--------------------------Homework1------------------------------");

        System.out.println("<<<POST>>>-------------------------------------------------------");
        User user = new User();
        user.setId(1);
        user.setName("Artem");
        user.setUserName("Artem401");
        user.setEmail("aretem401@gmail.com");
        User userCreate = MyHTTP.createUser(URI.create(USERS), user);                    // Post
        System.out.println(userCreate);

        System.out.println("<<<PUT>>>---------------------------------------------------------");
        System.out.println();
        User user1 = new User();
        user1.setName("Artem");
        user1.setUserName("Artem401");
        user1.setEmail("artem401@gmail.com");
        User updatedUser = MyHTTP.updateUser(URI.create(USERS), 2, user1);
        System.out.println("Updated user: " + updatedUser);

        System.out.println("<<<DELETE>>>-------------------------------------------------------");
        MyHTTP.deleteUser(URI.create(USERS), 6);

        System.out.println("<<<GET-ALL-USERS>>>------------------------------------------------");
        List<User> allUsers = MyHTTP.getAllUsers(URI.create(USERS));
        System.out.println("All users: " + allUsers.toString());

        System.out.println("<<<GET-BY-ID>>>----------------------------------------------------");
        User userById = MyHTTP.getUserById(URI.create(USERS), 2);
        System.out.println("User by id: " + userById);

        System.out.println("<<<GET-BY-USERNAME>>>-----------------------------------------------");
        String userName = "Leopoldo_Corkery";
        User userByUsername = MyHTTP.getUserByUsername(URI.create(USERS), userName);
        System.out.println("User by username: " + userByUsername);


        System.out.println("--------------------------Homework2------------------------------");
        int userId = 1;
        int lastPostId = MyHTTP.userLastPostFind(URI.create(USERS), userId);
        String commentsJson = MyHTTP.findLastPostComments(URI.create(USERS), userId, lastPostId);
        MyHTTP.writeCommentsToJson(commentsJson, userId, lastPostId);


        System.out.println("--------------------------Homework3------------------------------");
        MyHTTP.findAndWriteTodos(URI.create(USERS), 1);
    }
}




