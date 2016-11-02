///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package AnsLab3_201303347;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// *
// * @author deneir-uy
// */
//class Amino_Acid {
//    String name;
//    double kyte_doolittle;
//    double hopp_woods;
//    double cornette;
//    double eisenberg;
//    double rose;
//    double janine;
//    double engelman;
//
//    Amino_Acid(String name, double kyte_doolittle, double hopp_woods, double cornette,
//                double eisenberg, double rose, double janine, double engelman) {
//        this.name = name;
//        this.kyte_doolittle = kyte_doolittle;
//        this.hopp_woods = hopp_woods;
//        this.cornette = cornette;
//        this.eisenberg = eisenberg;
//        this.rose = rose;
//        this.janine = janine;
//        this.engelman = engelman;
//    }
//}
//
//class Amino_Acid_Sequence {
//    ArrayList<Amino_Acid> sequence = new ArrayList<>();
//
//    public Amino_Acid_Sequence(String sequenceString) {
//        
//    }
//    
//    private void setSequence(String sequenceString) {
//        for (int i = 0; i < sequenceString.length(); i++) {
//            this.sequence.add(e);
//        }
//    }
//
//    
//    
//    
//}
//
//class Hydrophobicity {
//    static HashMap<String, double[]> hydrophobicity = new HashMap<>();
//    
////    public static void initialize() {
////        hydrophobicity.put("A", new double[]{1.80, -0.50, 0.20, 0.62, 0.74, 0.30, 1.60});
////        hydrophobicity.put("C", new double[]{2.50, -1.00, 4.10, 0.29, 0.91, 0.90, 2.00});
////        hydrophobicity.put("D", new double[]{-3.50, 3.00, -3.10, -0.90, 0.62, -0.60, -9.20});
////        hydrophobicity.put("E", new double[]{-3.50, 3.00, -1.80, -0.74, 0.62, -0.70, -8.20});
////        hydrophobicity.put("F", new double[]{2.80, -2.50, 4.40, 1.19, 0.88, 0.50, 3.70});
////        hydrophobicity.put("G", new double[]{-0.40, 0.00, 0.00, 0.48, 0.72, 0.30, 1.00});
////        hydrophobicity.put("H", new double[]{-3.20, -0.50, 0.50, -0.40, 0.78, -0.10, -3.00});
////        hydrophobicity.put("I", new double[]{4.50, -1.80, 4.80, 1.38, 0.88, 0.70, 3.10});
////        hydrophobicity.put("K", new double[]{-3.90, 3.00, -3.10, -1.50, 0.52, -1.80, -8.80});
////        hydrophobicity.put("L", new double[]{3.80, -1.80, 5.70, 1.06, 0.85, 0.50, 2.80});
////        hydrophobicity.put("M", new double[]{1.90, -1.30, 4.20, 0.64, 0.85, 0.40, 3.40});
////        hydrophobicity.put("N", new double[]{-3.50, 0.20, -0.50, -0.78, 0.63, -0.50, -4.80});
////        hydrophobicity.put("P", new double[]{-1.60, 0.00, -2.20, 0.12, 0.64, -0.30, -0.20});
////        hydrophobicity.put("Q", new double[]{-3.50, 0.20, -2.80, -0.85, 0.62, -0.70, -4.10});
////        hydrophobicity.put("R", new double[]{-4.50, 3.00, 1.40, -2.53, 0.64, -1.40, -12.3});
////        hydrophobicity.put("S", new double[]{-0.80, 0.30, -0.50, -0.18, 0.66, -0.10, 0.60});
////        hydrophobicity.put("T", new double[]{-0.70, -0.40, -1.90, -0.05, 0.70, -0.20, 1.20});
////        hydrophobicity.put("V", new double[]{4.20, -1.50, 4.70, 1.08, 0.86, 0.60, 2.60});
////        hydrophobicity.put("W", new double[]{-0.90, -3.40, 1.00, 0.81, 0.85, 0.30, 1.90});
////        hydrophobicity.put("Y", new double[]{-1.30, -2.30, 3.20, 0.26, 0.76, -0.40, -0.7});
////    }
//    
//    public static void initialize() {
//        hydrophobicity.put("A", new Amino_Acid("Alanine", 1.80, -0.50, 0.20, 0.62, 0.74, 0.30, 1.60));
//        hydrophobicity.put("C", new Amino_Acid("Cysteine",2.50, -1.00, 4.10, 0.29, 0.91, 0.90, 2.00));
//        hydrophobicity.put("D", new Amino_Acid("Aspartic acid", -3.50, 3.00, -3.10, -0.90, 0.62, -0.60, -9.20));
//        hydrophobicity.put("E", new Amino_Acid("Glutamic acid", -3.50, 3.00, -1.80, -0.74, 0.62, -0.70, -8.20));
//        hydrophobicity.put("F", new Amino_Acid("Phenylalanine", 2.80, -2.50, 4.40, 1.19, 0.88, 0.50, 3.70));
//        hydrophobicity.put("G", new Amino_Acid("Glycine", -0.40, 0.00, 0.00, 0.48, 0.72, 0.30, 1.00));
//        hydrophobicity.put("H", new Amino_Acid("Histidine", -3.20, -0.50, 0.50, -0.40, 0.78, -0.10, -3.00));
//        hydrophobicity.put("I", new Amino_Acid("Isoleucine", 4.50, -1.80, 4.80, 1.38, 0.88, 0.70, 3.10));
//        hydrophobicity.put("K", new Amino_Acid("Lysine", -3.90, 3.00, -3.10, -1.50, 0.52, -1.80, -8.80));
//        hydrophobicity.put("L", new Amino_Acid("Leucine", 3.80, -1.80, 5.70, 1.06, 0.85, 0.50, 2.80));
//        hydrophobicity.put("M", new Amino_Acid("Methionine", 1.90, -1.30, 4.20, 0.64, 0.85, 0.40, 3.40));
//        hydrophobicity.put("N", new Amino_Acid("Asparagine", -3.50, 0.20, -0.50, -0.78, 0.63, -0.50, -4.80));
//        hydrophobicity.put("P", new Amino_Acid("Proline", -1.60, 0.00, -2.20, 0.12, 0.64, -0.30, -0.20));
//        hydrophobicity.put("Q", new Amino_Acid("Glutamine", -3.50, 0.20, -2.80, -0.85, 0.62, -0.70, -4.10));
//        hydrophobicity.put("R", new Amino_Acid("Arginine", -4.50, 3.00, 1.40, -2.53, 0.64, -1.40, -12.3));
//        hydrophobicity.put("S", new Amino_Acid("Serine", -0.80, 0.30, -0.50, -0.18, 0.66, -0.10, 0.60));
//        hydrophobicity.put("T", new Amino_Acid("Threonine", -0.70, -0.40, -1.90, -0.05, 0.70, -0.20, 1.20));
//        hydrophobicity.put("V", new Amino_Acid("Valine", 4.20, -1.50, 4.70, 1.08, 0.86, 0.60, 2.60));
//        hydrophobicity.put("W", new Amino_Acid("Tryptophan", -0.90, -3.40, 1.00, 0.81, 0.85, 0.30, 1.90));
//        hydrophobicity.put("Y", new Amino_Acid("Tyrosine", -1.30, -2.30, 3.20, 0.26, 0.76, -0.40, -0.70));
//    }
//}
