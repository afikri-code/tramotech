package de.tramotech;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class provides various methods to read a file and return its contents as a List of Strings.
 * Author: Ahmed Fikri
 */
public class FileReaderDemo {

    /**
     * Reads a file using BufferedReader and returns its contents as a List of Strings.
     *
     * @param fileName the name of the file to be read
     * @return a List of Strings containing the file contents
     * @throws RuntimeException if an error occurs while reading the file
     */
    public List<String> readFileUsingBufferedReader(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the file: " + fileName, e);
        }
    }

    /**
     * Reads a file using Files.lines() and returns its contents as a List of Strings.
     *
     * @param fileName the name of the file to be read
     * @return a List of Strings containing the file contents
     * @throws RuntimeException if an error occurs while reading the file
     */
    public List<String> readFileUsingFilesAndStream(String fileName) {
        List<String> lines;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the file: " + fileName, e);
        }
        return lines;
    }

    /**
     * Reads a file using Files.readAllLines() and returns its contents as a List of Strings.
     *
     * @param fileName the name of the file to be read
     * @return a List of Strings containing the file contents
     * @throws RuntimeException if an error occurs while reading the file
     */
    public List<String> readFileUsingFilesReadAllLines(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the file: " + fileName, e);
        }
    }

    /**
     * Reads a file using BufferedReader and a while loop, and returns its contents as a List of Strings.
     *
     * @param fileName the name of the file to be read
     * @return a List of Strings containing the file contents
     * @throws RuntimeException if an error occurs while reading the file
     */
    public List<String> readFileUsingBufferedReaderAndWhileLoop(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the file: " + fileName, e);
        }
    }

    /**
     * Reads a file using Scanner and returns its contents as a List of Strings.
     *
     * @param fileName the name of the file to be read
     * @return a List of Strings containing the file contents
     * @throws RuntimeException if the file is not found
     */
    public List<String> readFileUsingScanner(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            return lines;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        }
    }

    /**
     * Reads a file using BufferedReader and returns a list of strings representing each line in the file.
     *
     * @param fileName the name of the file to read
     * @param outputFileName the name of the file to write the result to
     * @throws RuntimeException if an error occurs while reading the file
     */
    public void readFileUsingBufferedReaderAndWriteToFile(String fileName, String outputFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<String> lines = br.lines().collect(Collectors.toList());
            Files.write(Paths.get(outputFileName), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the file: " + fileName, e);
        }
    }

    /**
     * Reads a file using a BufferedReader and writes its content to another file using a BufferedWriter,
     * while keeping the original order of the lines.
     * @param inputFileName the name of the input file to be read
     * @param outputFileName the name of the output file to be written
     * @throws RuntimeException if an error occurs while reading or writing the file
     */
    public void readFileUsingBufferedReaderAndWhileLoopAndWriteToFile(String inputFileName, String outputFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            if ((line = br.readLine()) != null) {
                bw.write(line);
            }
            while ((line = br.readLine()) != null) {
                bw.newLine();
                bw.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading or writing the file", e);
        }
    }


}

