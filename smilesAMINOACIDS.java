import java.util.Scanner;

public class smilesAMINOACIDS {

    public static void main(String[] args) {

        /*
        Starting with the most basic amino acid, glycine,
        where the R group is simply H. The purpose of this
        program is to (1) generate new amino acids based
        on hypothetical biotransformations and (2) output
        the SMILES of these amino acids so this can be run
        in R using rJava to calculate InChiKey and predicted
        retention times.
         */
        String glycine = "O=C(O)CN";

        //gathers info from the user about what they want to do
        //can select L vs D stereochemistry so far
        //L = 1 & D = 2
        Scanner stereochemScanner = new Scanner(System.in);
        System.out.println("1 for L & 2 for D stereochemistry");
        int stereochem = stereochemScanner.nextInt();

        //calls the RgroupAddition method
        RgroupAddition(glycine, stereochem);

    }

    public static void RgroupAddition(String glycine, int stereochem) {

        //String glycine = "O=C(O)CN";

        //length of glycine
        int lengthGlycine = 7;

        //generates constant "before chiral carbon"
        //returns O=C(O)
        String beforeChiralCarbon = glycine.substring(0,5);
        
        //after chiral carbon
        //returns N
        char afterChiralCarbon = glycine.charAt(lengthGlycine);

        //test R groups are tyrosine and also BMAA
        //will pring out both for test
        //deal with handeling these later...
        //L stereochemistry
        String L_stereo = "[C@H]";

        //D stereochemistry
        String D_stereo = "[C@@H]";

        //define the R group moieties
        //want to import from a .csv file eventually
            //defining tyrosine
            String tyrosine = "CC1=CC=C(O)C=C1";

            //defining BMAA
            String BMAA = "CNC";

        //define variable
        String newAminoAcidTyrosine = "";

        //generate tyrosine
        if (stereochem == 1) {
            newAminoAcidTyrosine = beforeChiralCarbon + "" + L_stereo + "(" + tyrosine + ")" + afterChiralCarbon;
        }
        else if (stereochem == 2) {
            newAminoAcidTyrosine = beforeChiralCarbon + "" + D_stereo + "(" + tyrosine + ")" + afterChiralCarbon;
        } 

        //return(newAminoAcidTyrosine);

        System.out.println(newAminoAcidTyrosine);

    }
    
}