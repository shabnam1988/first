package phonesimulator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id=0;

    public static void main(String[] args) {


        contacts=new ArrayList<>();
        System.out.println("Welcome to my World! ");
        showInitialOptions();

    }

    private static void showInitialOptions(){
        System.out.println("Please select one: "+
                "\n\t1. Manage Contacts "+
                "\n\t2. Messages"+
                "\n\t3. Quit");

        scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessage();
                break;
            default:
                break;
        }
    }

    private static void manageMessage() {
        System.out.println("Please select one: "+
                "\n\t1. Show all Messages"+
                "\n\t2. Send a new Message"+
                "\n\t3. Go Back");
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showInitialOptions();
        }
    }


    //The Methods of manageMessages
    private static void showAllMessages() {
        ArrayList<Message> allMessages=new ArrayList<>();
        for(Contact c:contacts){
            allMessages.addAll(c.getMessages());
        }
        if(allMessages.size()>0){
            for (Message m:allMessages){
                m.getDetail();
                System.out.println("****************");
            }
        }
        else{
            System.out.println("You dont have any Message");
        }
        showInitialOptions();
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send a Message");
        String name=scanner.next();
        if (name.equals("")){
            System.out.println("Please enter the name of contact ");
            sendNewMessage();
        }else{
            boolean doesExist=false;
            for (Contact c:contacts){
                if (c.getName().equals(name)){
                    doesExist=true;
                }
            }
            if(doesExist){
                System.out.println("What are you going to say?");
                String text=scanner.next();
                if (text.equals("")){
                    System.out.println("Please enter some message");
                    sendNewMessage();
                }else{
                   id++;
                   Message newMessage=new Message(text,name,id);
                   for (Contact c:contacts){
                       if (c.getName().equals(name)){
                           ArrayList<Message> newMessages=c.getMessages();
                           newMessages.add(newMessage);
                           c.setMessages(newMessages);

                       }
                   }

                }
            }else{
                System.out.println("There is no such contact");
            }
        }
        showInitialOptions();
    }

    private static void manageContacts(){
        System.out.println("Please select one: "+
                "\n\t1. Show all contacts"+
                "\n\t2. Add a new Contact"+
                "\n\t3. Search for a contact"+
                "\n\t4. Delete a Contact"+
                "\n\t5.Go back");
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    //The Methods of manageContacts
    private static void showAllContacts() {
        if (contacts.size()>0){
            for(Contact c:contacts){
                c.getDetails();
                System.out.println("*****************");
            }
            showInitialOptions();

        }else{
            System.out.println("You don not have any contacts");
            showInitialOptions();
        }

    }

    private static void addNewContact() {
        System.out.println("Adding a new Contact..."+"\nPlease enter the contact name: ");
        String name=scanner.next();
        System.out.println("Please enter the contact number: ");
        String number=scanner.next();
        System.out.println("Please enter the contact email: ");
        String email=scanner.next();

        if (name.equals("")||number.equals("")||email.equals("")){
            System.out.println("Please enter all of Information");
            addNewContact();
        }
        else{
            boolean doesExit=false;
            for (Contact c:contacts){
                if(c.getName().equals(name)){
                    doesExit=true;
                }
            }
            if (doesExit){
                System.out.println("We have already "+name+"in Your Phone.");
                addNewContact();
            }
            else {
                Contact contact=new Contact(name,number,email);
                contacts.add(contact);
                System.out.println(name+ " added successfully");
            }

        }
        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Please enzer the contact name: ");
        String name=scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name: ");
            searchForContact();
        }
        else{
            boolean doesExist=false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    doesExist=true;
                    c.getDetails();
                }
            }
            if (!doesExist){
                System.out.println("There is no such contact in your Phone");
            }
        }
        showInitialOptions();
    }

    private static void deleteContact() {
        System.out.println("Please enter the name");
        String name=scanner.next();
        if (name.equals("")){
            System.out.println("Please enter the name: ");
            deleteContact();
        }
        else {
            boolean doesExist=false;
            for (Contact c:contacts){
                if (c.getName().equals(name)){
                    doesExist=true;
                    contacts.remove(c);
                }
                if (!doesExist){
                    System.out.println("There is no such contact");
                }
            }
        }
        showInitialOptions();
    }
}
