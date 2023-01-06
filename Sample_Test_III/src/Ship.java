public class Ship {
        private double a, b, c;
        private double x, y;
        private int des;//ship can be designated 1 or 2

        Ship() {
            a = 0; b= 0;
            c = 0; x = 0;
            y = 0; des = 0;
        }

        Ship(double a0, double b0, double c0, double x0, double y0, int pos) {
            a = a0; b = b0;
            c = c0; x = x0;
            y = y0; des = pos;
        }

        public void setConstantAll(double a0, double b0, double c0, double x0, double y0, int pos) {
            a = a0; b = b0;
            c = c0; x = x0;
            y = y0; des = pos;
        }

        public void setConstantA(double a0) {
            a = a0;
        }

        public void setConstantB(double b0) {
            b = b0;
        }

        public void setConstantC(double c0) {
            c = c0;
        }

        public void setConstantX(double x0) {
            x = x0;
        }

        public void setConstantY(double y0) {
            y = y0;
        }

        public void setShipDes(int pos) {
            des = pos;
        }
        public double getConstantA() {
            return a;
        }

        public double getConstantB() {
            return b;
        }

        public double getConstantC() {
            return c;
        }

        public double getConstantX() {
            return x;
        }

        public double getConstantY() {
            return y;
        }

        public double getShipDes() {
            return des;
        }

        public String getString() {
            return "Ship " + des + ": " + a + " " + b + " " + c + " " + x + " " + y;
        }
}
