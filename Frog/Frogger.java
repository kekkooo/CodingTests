import java.util.*;

/**
 * Created by francescousai on 24/05/16.
 */

class Frogger {

    class Pos{
        private int position;
        private int currentTime;
        private int startingTime;

        public Pos(int position, int current, int starting) {
            this.position = position;
            this.currentTime = current;
            this.startingTime = starting;
        }

        public int getPosition() {
            return position;
        }

        public int getCurrentTime() {
            return currentTime;
        }

        public int getStartingTime() {
            return startingTime;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "position=" + position +
                    ", current=" + currentTime +
                    ", starting=" + startingTime +
                    '}';
        }
    }

    final int INVALID_TIME = -1;

    public int altSolution(int[] A, int X, int D) {

        if( D >= X ){ return  0; }
        if( A.length == 0 ) { return -1; }

        Stack<Pos> toVisit = new Stack<>();
        int positions[] = new int[X];

        Arrays.fill( positions, INVALID_TIME );

        // use reverse traversal in order to have, in the end, just the earliest second
        for( int i = A.length - 1; i >= 0; --i ){
            positions[ A[i]]  = i;
        }

        for( int i = 0; i < 3; ++i ){
            toVisit.push( new Pos( i, A[i], A[i] ) );
        }

        Pos current;
        ArrayList<Integer> times = new ArrayList<>();

        while( !toVisit.empty() ){
            current = toVisit.pop();

            for( int i = 1; i <= D; ++i ){
                int index = current.getPosition() + i;

                if( index >= X ) { times.add( current.getStartingTime( )); continue; }
                if( positions[index] == INVALID_TIME )              continue;
                if( positions[index] > current.getStartingTime() )  continue;

                toVisit.push( new Pos( index, positions[index], current.getStartingTime( )));
            }
        }

        return Collections.min( times );
    }
}
