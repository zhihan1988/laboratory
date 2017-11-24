/*
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/*
 *
 *
 *
 *
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */


import java.util.Random;

/**
 * A random number generator isolated to the current thread.  Like the
 * global {@link java.util.Random} generator used by the {@link
 * java.lang.Math} class, a {@code ThreadRandom} is initialized
 * with an internally generated seed that may not otherwise be
 * modified. When applicable, use of {@code ThreadRandom} rather
 * than shared {@code Random} objects in concurrent programs will
 * typically encounter much less overhead and contention.  Use of
 * {@code ThreadRandom} is particularly appropriate when multiple
 * tasks (for example, each a {@link ForkJoinTask}) use random numbers
 * in parallel in thread pools.
 *
 * <p>Usages of this class should typically be of the form:
 * {@code ThreadRandom.current().nextX(...)} (where
 * {@code X} is {@code Int}, {@code Long}, etc).
 * When all usages are of this form, it is never possible to
 * accidently share a {@code ThreadRandom} across multiple threads.
 *
 * <p>This class also provides additional commonly used bounded random
 * generation methods.
 *
 * <p>Instances of {@code ThreadRandom} are not cryptographically
 * secure.  Consider instead using {@link java.security.SecureRandom}
 * in security-sensitive applications. Additionally,
 * default-constructed instances do not use a cryptographically random
 * seed unless the {@linkplain System#getProperty system property}
 * {@code java.util.secureRandomSeed} is set to {@code true}.
 *
 * @since 1.7
 * @author Doug Lea
 */
public class ThreadRandom extends Random {

    public static void main(String[] args) {
        ThreadRandom test = new ThreadRandom();
        int target = 2;
        int[][] array ={{0,1,3,4,5,7,8,11,13,15,18,21,24,27,30,32,35,36,39,41,42,43,46,49,52,55,58,60,63,66,67,69,72,75,78,80,81,82,85,86},{1,4,6,8,11,12,15,17,18,20,23,24,27,30,33,34,38,39,42,44,47,48,51,52,55,57,59,62,64,67,70,72,75,77,81,83,84,87,90,91},{4,7,8,11,14,16,18,20,21,24,27,29,32,35,36,39,40,42,44,46,49,52,54,56,58,60,61,64,67,70,73,76,78,81,84,87,89,91,93,96},{5,8,10,13,15,19,21,23,24,27,29,31,34,37,38,41,43,45,46,49,52,55,58,59,61,64,67,69,71,72,76,78,79,83,87,90,91,94,96,97},{6,11,14,16,18,22,24,27,29,32,33,35,36,40,42,44,47,50,51,52,54,58,60,62,64,67,70,73,76,79,82,84,87,88,91,94,97,99,101,102},{9,13,16,19,21,23,25,29,31,35,38,39,42,45,48,51,54,56,57,60,63,64,67,69,72,73,74,76,79,81,85,88,90,92,95,98,100,101,104,106},{10,16,19,22,24,26,29,31,34,36,40,41,45,46,50,54,56,59,60,63,66,69,70,72,75,77,79,81,83,85,88,91,93,96,98,99,102,105,107,109},{12,18,22,25,26,29,32,33,37,39,42,44,47,50,52,57,59,61,62,66,68,71,72,74,76,80,82,84,87,90,92,94,95,98,101,102,105,107,109,112}};
        System.out.println(test.Find(target, array));
    }

    public boolean Find(int target, int [][] array) {
        boolean result = false;
        int isize = array.length;
        if (isize == 0) {
            return false;
        }
        int jsize = array[0].length;
        if (jsize == 0) {
            return false;
        }
        if (array[0][0] > target) {
            return false;
        }

        boolean out = false;
        int j=0;
        for(int i=0;i<isize;i++){
            if(!out){
                for(j=0;j<jsize;j++){
                    if(array[i][j] == target){
                        return true;
                    } else if (array[i][j]>target){
                        out = true;
                        break;
                    }
                }
                j--;
            }
            if(array[i][j]==target){
                return true;
            }
        }
        return result;
    }
}
