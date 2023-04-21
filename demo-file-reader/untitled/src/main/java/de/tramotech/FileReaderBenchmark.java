package de.tramotech;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.List;

/**
 * Author: Ahmed Fikri
 */
@State(Scope.Benchmark)
public class FileReaderBenchmark {

    private static final String FILE_NAME = "/Users/afikri/dev/tmp/customer.csv";
    FileReaderDemo reader;

    @Setup
    public void setUp() {
        reader = new FileReaderDemo();
    }

    /**
     * Reads a file using a BufferedReader and stores the lines in memory.
     * This method is annotated with JMH annotations for benchmarking purposes.
     *
     * @param bh The Blackhole object used to prevent the optimizer from eliminating the consumed lines.
     */
    @Benchmark // Marks this method as a JMH benchmark method
    @Measurement(iterations = 2) // Specifies the number of iterations for each benchmark measurement
    @Fork(value = 2) // Specifies the number of times to fork a single benchmark
    @Warmup(iterations = 2) // Specifies the number of iterations for the warmup phase of each benchmark
    public void readFileUsingBufferedReader(Blackhole bh) {
        // Read the file and store the lines in memory before the benchmark runs
        List<String> lines = reader.readFileUsingBufferedReader(FILE_NAME);
        bh.consume(lines); // consume the lines to prevent optimizer from eliminating this step

        /*
        // Get the memory usage after GC
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        memoryBean.gc();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        long memoryUsed = heapUsage.getUsed();
        System.out.println("Memory used after GC: " + memoryUsed + " bytes");
        */
    }


    /**
     * Measures the performance of reading a file using Java 8 Files and Stream API.
     * Reads the file and stores the lines in memory before the benchmark runs.
     * Consumes the lines to prevent optimizer from eliminating this step.
     *
     * @param bh the Blackhole object to consume the lines and prevent dead code elimination
     */
    @Benchmark // Marks this method as a JMH benchmark method
    @Measurement(iterations = 2) // Specifies the number of iterations for each benchmark measurement
    @Fork(value = 2) // Specifies the number of times to fork a single benchmark
    @Warmup(iterations = 2) // Specifies the number of iterations for the warmup phase of each benchmark
    public void readFileUsingFilesAndStream(Blackhole bh){
        // Read the file and store the lines in memory before the benchmark runs
        List<String> lines = reader.readFileUsingFilesAndStream(FILE_NAME);
        bh.consume(lines); // consume the lines to prevent optimizer from eliminating this step

        /*
        // Get the memory usage after GC
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        memoryBean.gc();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        long memoryUsed = heapUsage.getUsed();
        System.out.println("Memory used after GC: " + memoryUsed + " bytes");

        */
    }


    /**
     * Benchmarks the performance of reading a file using the Files readAllLines method.
     *
     * @param bh the Blackhole object to consume the result and prevent the optimizer from eliminating the step
     */
    @Benchmark // Marks this method as a JMH benchmark method
    @Measurement(iterations = 2) // Specifies the number of iterations for each benchmark measurement
    @Fork(value = 2) // Specifies the number of times to fork a single benchmark
    @Warmup(iterations = 2) // Specifies the number of iterations for the warmup phase of each benchmark
    public void readFileUsingFilesReadAllLines(Blackhole bh) {
        // Read the file and store the lines in memory before the benchmark runs
        List<String> lines = reader.readFileUsingFilesReadAllLines(FILE_NAME);
        bh.consume(lines); // consume the lines to prevent optimizer from eliminating this step

        /*
        // Get the memory usage after GC
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        memoryBean.gc();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        long memoryUsed = heapUsage.getUsed();
        System.out.println("Memory used after GC: " + memoryUsed + " bytes");

        */
    }

    /**
     * Reads the file using BufferedReader and while loop, and consumes the lines using Blackhole.
     *
     * @param bh the Blackhole instance used to consume the lines to prevent optimizer from eliminating this step.
     */
    @Benchmark // Marks this method as a JMH benchmark method
    @Measurement(iterations = 2) // Specifies the number of iterations for each benchmark measurement
    @Fork(value = 2) // Specifies the number of times to fork a single benchmark
    @Warmup(iterations = 2) // Specifies the number of iterations for the warmup phase of each benchmark
    public void readFileUsingBufferedReaderAndWhileLoop(Blackhole bh) {
        // Read the file and store the lines in memory before the benchmark runs
        List<String> lines = reader.readFileUsingBufferedReaderAndWhileLoop(FILE_NAME);
        bh.consume(lines); // consume the lines to prevent optimizer from eliminating this step

        /*
        // Get the memory usage after GC
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        memoryBean.gc();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        long memoryUsed = heapUsage.getUsed();
        System.out.println("Memory used after GC: " + memoryUsed + " bytes");

        */
    }

    /**
     * Benchmarks the performance of reading a file using a Scanner.
     *
     * @param bh the Blackhole object used to consume the lines read from the file
     */
    @Benchmark // Marks this method as a JMH benchmark method
    @Measurement(iterations = 2) // Specifies the number of iterations for each benchmark measurement
    @Fork(value = 2) // Specifies the number of times to fork a single benchmark
    @Warmup(iterations = 2) // Specifies the number of iterations for the warmup phase of each benchmark
    public void readFileUsingScanner(Blackhole bh) {
        // Read the file and store the lines in memory before the benchmark runs
        List<String> lines = reader.readFileUsingScanner(FILE_NAME);
        bh.consume(lines); // consume the lines to prevent optimizer from eliminating this step

        /*
        // Get the memory usage after GC
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        memoryBean.gc();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        long memoryUsed = heapUsage.getUsed();
        System.out.println("Memory used after GC: " + memoryUsed + " bytes");

        */
    }
}

