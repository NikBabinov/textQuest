package ru.mail.nikbabinov.main_quest.service;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserFileManager {
    public static boolean saveUsersToFile(ServletRequest request, String email, String password) {
        String pass = hashPassword(password);
        String realPathToFileUserDB = getRealPathToFileUserDatabase(request);
        String userData = email + ":" + pass + ",";
        synchronized (realPathToFileUserDB) {
            try (FileWriter writer = new FileWriter(realPathToFileUserDB, true)) {
                writer.write(userData);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

    }

    public static boolean readUsersFromFile(ServletRequest request, String email, String password) {
        String realPathToFileUserDB = getRealPathToFileUserDatabase(request);
        String[] allUserData = getAllUserDB(realPathToFileUserDB).split(",");
        for (String allUserDatum : allUserData) {
            if (allUserDatum.contains(email)) {
                String[] userData = allUserDatum.split(":");
                return (userData[1].equals(hashPassword(password)));
            }
        }
        return false;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getRealPathToFileUserDatabase(ServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        String path = servletContext.getRealPath("/WEB-INF/classes/db/");
        String filename = "users.txt";
        String realPath = path + filename;
        return realPath;
    }

    private static String getAllUserDB(String pathToFileUserDB) {
        synchronized (pathToFileUserDB) {
            StringBuilder result = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(pathToFileUserDB))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    result.append('\n');
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result.toString();
        }
    }
}

