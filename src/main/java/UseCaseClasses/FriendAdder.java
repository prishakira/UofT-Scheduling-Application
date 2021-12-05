package UseCaseClasses;

import Entities.Person;

import java.util.ArrayList;

public class FriendAdder {
    /** Adds users to friend list by sending invitations, then accepting invitations.
     *
     * @param user1 the username of user1 who sends friend request
     * @param user2 the username of user2 who receives/ accepts friend request
     *
     */

    public boolean sendFriendRequest(Person user1, Person user2, UserList data){
        /* user 1 sends friend request to user 2
         */
        boolean checkReal = data.containsUser(user1.getUserName()) &&
                data.containsUser(user2.getUserName());

        if (checkReal) {
            ArrayList<Person> outgoing = user1.getOutgoingRequests();
            outgoing.add(user2);
            user1.setOutgoingRequests(outgoing);

            ArrayList<Person> incoming = user1.getIncomingRequests();
            incoming.add(user1);
            user2.setIncomingRequests(incoming);
        }

        return checkReal;

    }

    public boolean acceptFriendRequest(Person user1, Person user2, UserList data){
        /*user 2 accepts user1's friend request
         */

        boolean checkReal = data.containsUser(user1.getUserName()) &&
                data.containsUser(user2.getUserName());

        if (checkReal) {
            ArrayList<Person> user2IncomingRequests = user2.getIncomingRequests();
            user2IncomingRequests.remove(user1);
            user2.setIncomingRequests(user2IncomingRequests);

            ArrayList<Person> user1OutgoingRequests = user1.getOutgoingRequests();
            user1OutgoingRequests.remove(user2);
            user1.setOutgoingRequests(user1OutgoingRequests);

            ArrayList<Person> user1Friends = user1.getUserFriends();
            user1Friends.add(user2);
            user1.setUserFriends(user1Friends);

            ArrayList<Person> user2Friends = user2.getUserFriends();
            user2Friends.add(user1);
            user2.setUserFriends(user2Friends);
        }

    }
}
