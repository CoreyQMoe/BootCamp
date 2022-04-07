package inClass.LmabdaandConcurrency;

public class sqrtimplementation {
    SquareRootInterface var = new SquareRootInterface() {
        @Override
        public double findsqrt(int n) {
            return Math.sqrt(n);
        }
    };
}
