import java.util.*;

public class game{
    public static void main(String[] args) {

    }

    Scanner scan = new Scanner(System.in);

    class Player{
        
        private double Power;
        private double Intel;
        private double Points;
        private int TurnsToGrowth;
        private String name;
        
        public Player(String nme) {
            this.name = nme;
            this.Power = 10;
            this.Intel = 10;
            this.Points = this.Power + this.Intel;
            this.TurnsToGrowth = 5;
        }

        void Take_tile(Tile tile) {
            if (tile.own == "none") {
                tile.own = name;
                this.Power -= -0.5;
                this.Intel += 0.25;
                this.tile.Bonus_type += tile.Bonus_val;
            } else if (tile.own != this.name) {
                Fight(tile.own, tile);
            } else {
                System.out.println("It's already your land!");
            }
        }

        void TTGreduce() {
            this.Intel -= 1;
            this.TurnsToGrowth -= 1;
        }

        void Grow() {
            this.Intel += 0.75;
            this.Power += 0.5;
        }

        void Fight(Player opp, Tile tile) {
            if (this.Power > opp.Power) {
                this.Power -= (this.Power - opp.Power) / 3;
                opp.Power -= (this.Power - opp.Power) / 2;
                opp.Intel -= 0.25;
                this.Intel += 0.25;
                tile.own = this.name;
            } else if (this.Power < opp.Power) {
                this.Power -= Math.abs(this.Power - opp.Power) / 2;
                opp.Power -= Math.abs(this.Power - opp.Power) / 3;
            } else {
                this.Power -= Math.abs(this.Power - opp.Power) / 3;
            }
        }
    }

    class Tile tile {
        private String own;
        private String Bonus_type;
        private double Bonus_val;
        public Tile(String owner, String B_t, double B_v) {
            this.own = owner;
            this.Bonus_type = B_t;
            this.Bonus_val = B_v;
        }
    }
}
