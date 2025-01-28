import java.util.ArrayList;
import java.util.List;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List of friends' User IDs
    User next; // Pointer to the next user in the list

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Age: " + age + ", Friends: " + friendIds;
    }
}

class SocialMedia {
    private User head = null;

    // Add a user to the system
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User " + name + " added to the system.");
    }

    // Search for a user by User ID
    public User searchUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Search for a user by Name
    public User searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove((Integer) userId2);
        user2.friendIds.remove((Integer) userId1);

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = searchUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friendIds) {
            User friend = searchUserById(friendId);
            if (friend != null) {
                System.out.println(friend.name + " (User ID: " + friend.userId + ")");
            }
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                User mutualFriend = searchUserById(friendId);
                if (mutualFriend != null) {
                    System.out.println(mutualFriend.name + " (User ID: " + mutualFriend.userId + ")");
                }
            }
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users in the system
    public void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in the system.");
            return;
        }

        User temp = head;
        System.out.println("Users in the system:");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Add users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "Diana", 28);

        // Display all users
        sm.displayAllUsers();

        // Add friend connections
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 4);

        // Display friends of a user
        sm.displayFriends(1);

        // Find mutual friends
        sm.findMutualFriends(1, 2);

        // Remove a friend connection
        sm.removeFriendConnection(1, 3);

        // Display friends after removal
        sm.displayFriends(1);

        // Count friends for each user
        sm.countFriends();
    }
}
