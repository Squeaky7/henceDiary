package system;

import java.util.Random;
import java.util.Scanner;

public class GameSys {

    static Scanner scan = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        clearConsole();
        
        int gameMenu1 = 0;

        System.out.println("Welcome to ElmntChar");

        while (gameMenu1 < 1 || gameMenu1 > 4) {
            clearConsole();
            gameMenu1 = gameMenuDis();
        }
		
        gameMenuSelected(gameMenu1);
    }

    // Show game menu
    private static int gameMenuDis() {
        System.out.println("Please select a Menu\n");

        System.out.println("1. Solve the Problem.");
        System.out.println("2. Look at the List of All Elements.");
        System.out.println("3. View play history.");
        System.out.println("4. Exit.");

        int selectedOption = inputInt();

        try {
            if (selectedOption < 1 || selectedOption > 4) {
                System.err.println("Invalid input. Please enter a number between 1 and 4.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter a number between 1 and 4.");
            gameMenuSelected(gameMenuDis());
        }

        return selectedOption;
    }

    // Clearing console
    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Process menu select
    private static void gameMenuSelected(int slct) {
        switch (slct) {
            case 1: // Solve the problems
                clearConsole();
                solveMenuDis();
                break;
            case 2: // View elements chart
                clearConsole();
                elmntChartDis();
                ChartControl(inputString());
                break;
            case 3: // View play history

                break;
            case 4: // Exit
                break;
        }
    }

    private static void elmntChartDis() {
        System.out.println("\nH                                                                   He (2)");
        System.out.println("Li  Be                                          B   C   N   O   F   Ne (10)");
        System.out.println("Na  Mg                                          Al  Si  P   S   Cl  Ar (18)");
        System.out.println("K   Ca  Sc  Ti  V   Cr  Mn  Fe  Co  Ni  Cu  Zn  Ga  Ge  As  Se  Br  Kr (36)");
        System.out.println("Rb  Sr  Y   Zr  Nb  Mo  Tc  Ru  Rh  Pd  Ag  Cd  In  Sn  Sb  Te  I   Xe (54)");
        System.out.println("Cs  Ba [La] Hf  Ta  W   Re  Os  Ir  Pt  Au  Hg  Tl  Pb  Bi  Po  At  Rn (86)");
        System.out.println("Fr  Ra [Ac] Rf  Db  Sg  Bh  Hs  Mt  Ds  Rg  Cn  Nh  Fl  Mc  Lv  Ts  Og (118)\n");
        System.out.println("        La  Ce  Pr  Nd  Pm  Sm  Eu  Gd  Tb  Dy  Ho  Er  Tm  Yb  Lu (71)");
        System.out.println("        Ac  Th  Pa  U   Np  Pu  Am  Cm  Bk  Cf  Es  Fm  Md  No  Lr (103)");

        System.out.println("Enter 1-118 to view details for each element.");
        System.out.println("\n\nPlease enter \"q\" to go back to the menu.");

    }

    // 周期表の詳細表示・退出
    private static void ChartControl(String input){        
        try {
            int elementNumber = Integer.parseInt(input);
            if(elementNumber >= 1 && elementNumber <= 118){
                DetailDis(elementNumber);
                ChartControlsub(inputString());
            }else{
                clearConsole();
                elmntChartDis();
                if(input.equals("q")) System.err.println("Invalid input. Please enter a number between 1 and 118, or 'q' to quit.");
                ChartControl(inputString());
            }
        } catch (NumberFormatException e) {
            if(input.equals("q")){
                clearConsole();
                gameMenuSelected(gameMenuDis());
            }else {
                clearConsole();
                elmntChartDis();
                System.err.println("Invalid input. Please enter a number between 1 and 118, or 'q' to quit.");
                ChartControl(inputString());
            }
        }
    }

    private static void ChartControlsub(String input){        
        try {
            int elementNumber = Integer.parseInt(input);
            if(elementNumber >= 1 && elementNumber <= 118){
                DetailDis(elementNumber);
                ChartControlsub(inputString());
            }else{
                clearConsole();
                elmntChartDis();
                if(input.equals("q")) System.err.println("Invalid input. Please enter a number between 1 and 118, or 'q' to quit.");
                ChartControl(inputString());
            }
        } catch (NumberFormatException e) {
            if(input.equals("q")){
                clearConsole();
                ChartControl(inputString());
            }else {
                clearConsole();
                elmntChartDis();
                System.err.println("Invalid input. Please enter a number between 1 and 118, or 'q' to quit.");
                ChartControl(inputString());
            }
        }
    }

    // Show solve menu
    private static void solveMenuDis(){
        System.out.println("1. Atomic Number -> Symbol");
        System.out.println("2. Atomic Number -> Name");
        System.out.println("3. Empty Field -> Symbol");
        System.out.println("4. Empty Field -> Name");
        
    }

    // ユーザーの入力をint型で返す
    private static int inputInt(){
        int userInputInt = scan.nextInt();
        
        return userInputInt;
    }

    // ユーザーの入力をString型で返す
    private static String inputString(){
        String userString = scan.nextLine();

        return userString;
    }

    protected  static void DetailDis(int index){
        DetailInfoDis detail = DetailInfoDis.getData(index);

        // Line 1
        System.out.print("\nAtom #: " + detail.getAtomNumber());
        System.out.print(" | Name: " + detail.getElName());
        System.out.print(" | Symbol: " + detail.getSymbol()); 
        System.out.println(" | Mass: " + detail.getMass());

        System.out.println("\n______________________________________________________________\n");

        System.out.println("Phase at STP: " + detail.getPhaseSTP());
        System.out.println("Color: " + (detail.getColor() != null ? detail.getColor() : "Colorless"));

        System.out.println("\npH Index: " + (detail.getPhIndex() != null ? detail.getPhIndex() : "--") + " " + (detail.getPhDetail() != null ? detail.getPhDetail() : ""));

        System.out.println("\nDensity: " + (detail.getDensity() != null ? detail.getDensity() + " " + detail.getDensityUnit() + (detail.getDensityEnv() != null ? " " + detail.getDensityEnv() : "") : "--"));
        System.out.println("Melting Pt: " + (detail.getMeltPt() != null ? detail.getMeltPt() + "℃" : "--"));
        


    }
}
