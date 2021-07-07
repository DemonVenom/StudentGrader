import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args)
    {

        // Initialize all grades into three-dimensional array
        int[][][] array={
                {{90,85},{74,86},{96,92}},
                {{75,82},{88,91},{86,94}},
                {{86,92},{84,82},{88,74}},
                {{83,90},{92,88},{87,91}}
            };

        // Initialize variable to store the total amount of test scores
        // to calculate the average for later
        double totalTestScores = 0;

        // Initialize all grade weights into one-dimensional array
        double[] weights = {0.25, 0.375, 0.375};

        // Create two-dimensional array to input student averages into later
        double[][] studentAvg = new double[4][4];

        // Initialize variable to store the total amount of class score
        // to calculate the averages for later
        double totalClassScores = 0;

        // Create counter variables to be used by for loops
        int i, j, k;



        // Create header for the class, class weight, and test data
        System.out.printf("\n%s %15s %15s %15s",
                "Data", "110(.25)", "210(.375)", "220(.375)");
        System.out.printf("\n%20s %15s %15s\n",
                "T1    T2", "T1    T2", "T1    T2");

        // Create for loop to iterate through each student
        for(i=0; i<4; i++) {

            // Create header to represent student, adding +1 for each student iterated through
            System.out.printf("%5s%d", "S", (i+1) );

            // Create for loop to iterate through each students' three grades
            for(j=0; j<3; j++) {

                // Create for loop to iterate through each students' grades' tests
                for(k=0; k<2; k++) {

                    // Print out test score
                    System.out.printf("%8s", array[i][j][k]);
                }

            }
            // Enter a new line when a student's data has been entered
            System.out.println();
        }


        // Create header to show the average score of all students that took the test
        System.out.printf("\nTest\nAverage     ");

        // Create for loop to iterate through each grade
        for (k = 0; k < 3; k++) {

            // Create for loop to iterate through each grades' test
            for (i = 0; i < 2; i++) {

                // Create for loop to iterate through each student
                for (j = 0; j < 4; j++) {

                    // Sum up all test scores of all students
                    totalTestScores = array[j][k][i] + totalTestScores;
                }
                // Calculate and print out the AVERAGE of all four students
                System.out.printf("%.2f   ", (totalTestScores / 4));
                // Reset the total test scores to zero
                totalTestScores = 0;
            }
        }


        // Create new header for the student grades generated from the average of both tests
        System.out.printf("\n\n%s %15s %15s %15s %15s\n",
                "Student Avgs", "110", "210", "220", "ETM Average");

        // Create for loop to iterate through each student
        for(i=0; i<4; i++) {

            // Create header to represent student, adding +1 for each student iterated through
            System.out.printf("%12s%d", "S", (i+1) );

            // Create for loop to iterate through each grades' test
            for(j=0; j<3; j++) {

                // Assign student test average (rounded to two decimal places)
                // to 2D array at index i student
                studentAvg[i][j] = Math.round( ((array[i][j][0] + array[i][j][1]) / 2.0) * 100.0) / 100.0;
                // Print out this average
                System.out.printf("%15.2f ", studentAvg[i][j]);

                // Assign student average of all classes (ETM) to the last position of array
                studentAvg[i][3] = (studentAvg[i][j] * weights[j]) + studentAvg[i][3];
            }
            // Print out ETM Average
            System.out.printf("%15.2f\n", studentAvg[i][3]);
        }



        // Create Class Average label
        System.out.printf("\n%15s", "Class Average");

        // Create for loop to iterate through each student
        for (i=0; i<4; i++) {

            // Create for loop to iterate through each average
            for (j=0; j<4; j++) {

                // Add class average to total students' class averages
                totalClassScores = studentAvg[j][i] + totalClassScores;

            }
            // Calculate and print out this average
            System.out.printf("%15.2f", (totalClassScores / 4));
            // Reset total class scores
            totalClassScores = 0;
        }
        // End the program on a new line
        System.out.println();

    }
}