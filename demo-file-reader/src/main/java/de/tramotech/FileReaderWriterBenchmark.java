package de.tramotech;

import org.openjdk.jmh.annotations.*;


/**
 * Author: Ahmed Fikri
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.All)
public class FileReaderWriterBenchmark {

    private static final String INPUT_FILE_NAME = "/Users/afikri/dev/tmp/customer.csv";
    private static final String OUTPUT_FILE_NAME = "/Users/afikri/dev/tmp/customer_output.csv";

    FileReaderDemo reader;

    @Setup
    public void setUp() {
        reader = new FileReaderDemo();
    }

    /**
     * Benchmark method that measures the performance of reading a file using BufferedReader and writing the
     * contents to a new file.
     * The method is annotated with JMH annotations to configure the benchmark:
     *
     */
    @Benchmark // Marks this method as a JMH benchmark method
    @Measurement(iterations = 2) // Specifies the number of iterations for each benchmark measurement
    @Fork(value = 2) // Specifies the number of times to fork a single benchmark
    @Warmup(iterations = 2) // Specifies the number of iterations for the warmup phase of each benchmark
    public void readFileUsingBufferedReaderAndWriteToFile() {
        // Read the file and store the lines in memory before the benchmark runs
        reader.readFileUsingBufferedReaderAndWriteToFile(INPUT_FILE_NAME, OUTPUT_FILE_NAME);

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
     * Benchmark method that measures the performance of reading a file using BufferedReader and writing the
     * contents to a new file.
     * The method is annotated with JMH annotations to configure the benchmark:
     *
     */

    @Benchmark // Marks this method as a JMH benchmark method
    @Measurement(iterations = 2) // Specifies the number of iterations for each benchmark measurement
    @Fork(value = 2) // Specifies the number of times to fork a single benchmark
    @Warmup(iterations = 2) // Specifies the number of iterations for the warmup phase of each benchmark
    public void readFileUsingBufferedReaderAndWhileLoopAndWriteToFile() {
        // Read the file and store the lines in memory before the benchmark runs
        reader.readFileUsingBufferedReaderAndWhileLoopAndWriteToFile(INPUT_FILE_NAME, OUTPUT_FILE_NAME);

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
