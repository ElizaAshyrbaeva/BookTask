package service.impl;

import enams.Gender;
import model.User;
import service.UserService;

import java.awt.print.Book;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserImpl implements UserService {
    private List<User> users = new LinkedList<>();

    @Override
    public String createUser(List<User> users) {
        this.users.addAll(users);
        return "Successfully created!";
    }


    @Override
    public List<User> findAllUsers() {
        return this.users;
    }

    @Override
    public User findUserById(Long id) {
        for (User user : users) {
            if (user.getId().longValue() == id) {
                users.add(user);
            }
        }
        return (User) users;
    }

    @Override
    public String removeUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                users.remove(user);
            }
        }
        return null;
    }

    @Override
    public void updateUser(Long id) {
        List<User> users1 = new LinkedList<>();
        for (User user : this.users) {
            if (user.getId().equals(id)) {
                users1.add(user);
            }
        }
    }

    @Override
    public void groupUsersByGender() {
        this.users.stream().filter(x -> x.getGender().equals(Gender.MALE)).forEach(System.out::println);
        this.users.stream().filter(x -> x.getGender().equals(Gender.FEMALE)).forEach(System.out::println);
    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        List<model.Book>books1 = new LinkedList<>();
        for (Book book : books) {
            if (book.getName().equals(name)) {
                System.out.println("Enter user id:");
                long id = new Scanner(System.in).nextLong();
                for (User user : this.users) {
                    if (Objects.equals(user.getId(), id)) {
                        user.setBooks(List.of());
                        return "Book pay successfully!!";
                    }
                }
            }

        }
        return name;
    }
}