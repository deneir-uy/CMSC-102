/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnsLab3_201303347;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

/**
 *
 * @author deneir-uy
 */
class Amino_Acid {

    static HashMap<String, double[]> hydrophobicityScale = new HashMap<>();
    private String name;
    private double[] hydrophobicity;
    private double kyte_doolittle;
    private double hopp_woods;
    private double cornette;
    private double eisenberg;
    private double rose;
    private double janine;
    private double engelman;

    Amino_Acid(String name) {
        initialize();
        this.name = name;
        this.hydrophobicity = hydrophobicityScale.get(name);
        this.kyte_doolittle = hydrophobicity[0];
        this.hopp_woods = hydrophobicity[1];
        this.cornette = hydrophobicity[2];
        this.eisenberg = hydrophobicity[3];
        this.rose = hydrophobicity[4];
        this.janine = hydrophobicity[5];
        this.engelman = hydrophobicity[6];
    }

    public static void initialize() {
        hydrophobicityScale.put("A", new double[]{1.80, -0.50, 0.20, 0.62, 0.74, 0.30, 1.60});
        hydrophobicityScale.put("C", new double[]{2.50, -1.00, 4.10, 0.29, 0.91, 0.90, 2.00});
        hydrophobicityScale.put("D", new double[]{-3.50, 3.00, -3.10, -0.90, 0.62, -0.60, -9.20});
        hydrophobicityScale.put("E", new double[]{-3.50, 3.00, -1.80, -0.74, 0.62, -0.70, -8.20});
        hydrophobicityScale.put("F", new double[]{2.80, -2.50, 4.40, 1.19, 0.88, 0.50, 3.70});
        hydrophobicityScale.put("G", new double[]{-0.40, 0.00, 0.00, 0.48, 0.72, 0.30, 1.00});
        hydrophobicityScale.put("H", new double[]{-3.20, -0.50, 0.50, -0.40, 0.78, -0.10, -3.00});
        hydrophobicityScale.put("I", new double[]{4.50, -1.80, 4.80, 1.38, 0.88, 0.70, 3.10});
        hydrophobicityScale.put("K", new double[]{-3.90, 3.00, -3.10, -1.50, 0.52, -1.80, -8.80});
        hydrophobicityScale.put("L", new double[]{3.80, -1.80, 5.70, 1.06, 0.85, 0.50, 2.80});
        hydrophobicityScale.put("M", new double[]{1.90, -1.30, 4.20, 0.64, 0.85, 0.40, 3.40});
        hydrophobicityScale.put("N", new double[]{-3.50, 0.20, -0.50, -0.78, 0.63, -0.50, -4.80});
        hydrophobicityScale.put("P", new double[]{-1.60, 0.00, -2.20, 0.12, 0.64, -0.30, -0.20});
        hydrophobicityScale.put("Q", new double[]{-3.50, 0.20, -2.80, -0.85, 0.62, -0.70, -4.10});
        hydrophobicityScale.put("R", new double[]{-4.50, 3.00, 1.40, -2.53, 0.64, -1.40, -12.3});
        hydrophobicityScale.put("S", new double[]{-0.80, 0.30, -0.50, -0.18, 0.66, -0.10, 0.60});
        hydrophobicityScale.put("T", new double[]{-0.70, -0.40, -1.90, -0.05, 0.70, -0.20, 1.20});
        hydrophobicityScale.put("V", new double[]{4.20, -1.50, 4.70, 1.08, 0.86, 0.60, 2.60});
        hydrophobicityScale.put("W", new double[]{-0.90, -3.40, 1.00, 0.81, 0.85, 0.30, 1.90});
        hydrophobicityScale.put("Y", new double[]{-1.30, -2.30, 3.20, 0.26, 0.76, -0.40, -0.7});
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the kyte_doolittle
     */
    public double getKyte_doolittle() {
        return kyte_doolittle;
    }

    /**
     * @param kyte_doolittle the kyte_doolittle to set
     */
    public void setKyte_doolittle(double kyte_doolittle) {
        this.kyte_doolittle = kyte_doolittle;
    }

    /**
     * @return the hopp_woods
     */
    public double getHopp_woods() {
        return hopp_woods;
    }

    /**
     * @param hopp_woods the hopp_woods to set
     */
    public void setHopp_woods(double hopp_woods) {
        this.hopp_woods = hopp_woods;
    }

    /**
     * @return the cornette
     */
    public double getCornette() {
        return cornette;
    }

    /**
     * @param cornette the cornette to set
     */
    public void setCornette(double cornette) {
        this.cornette = cornette;
    }

    /**
     * @return the eisenberg
     */
    public double getEisenberg() {
        return eisenberg;
    }

    /**
     * @param eisenberg the eisenberg to set
     */
    public void setEisenberg(double eisenberg) {
        this.eisenberg = eisenberg;
    }

    /**
     * @return the rose
     */
    public double getRose() {
        return rose;
    }

    /**
     * @param rose the rose to set
     */
    public void setRose(double rose) {
        this.rose = rose;
    }

    /**
     * @return the janine
     */
    public double getJanine() {
        return janine;
    }

    /**
     * @param janine the janine to set
     */
    public void setJanine(double janine) {
        this.janine = janine;
    }

    /**
     * @return the engelman
     */
    public double getEngelman() {
        return engelman;
    }

    /**
     * @param engelman the engelman to set
     */
    public void setEngelman(double engelman) {
        this.engelman = engelman;
    }

    /**
     * @return the hydrophobicity
     */
    public double[] getHydrophobicity() {
        return hydrophobicity;
    }

    /**
     * @param hydrophobicity the hydrophobicity to set
     */
    public void setHydrophobicity(double[] hydrophobicity) {
        this.hydrophobicity = hydrophobicity;
    }
}

class Amino_Acid_Sequence {

    ArrayList<Amino_Acid> sequence;
    double[] averages;
    double[] positions;
    private String description;
    int segments;

    public Amino_Acid_Sequence() {
        this.description = "";
        this.sequence = new ArrayList<>();
        this.segments = 0;
    }

    public Amino_Acid_Sequence(String sequenceString) {
        setSequence(sequenceString);
    }

    public void setSequence(String sequenceString) {
        for (int i = 0; i < sequenceString.length(); i++) {
            this.sequence.add(new Amino_Acid(Character.toString(sequenceString.charAt(i))));
        }
    }

    public ArrayList<Amino_Acid> getSequence() {
        return this.sequence;
    }

    public String getSequenceString() {
        String sequenceString = "";

        for (int i = 0; i < sequence.size(); i++) {
            sequenceString += sequence.get(i).getName();
        }

        return sequenceString;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public void setAverages(ArrayList<Double> averages) {
        this.averages = new double[averages.size()];

        for (int i = 0; i < this.averages.length; i++) {
            this.averages[i] = averages.get(i).doubleValue();
        }
    }

    public void setPositions(ArrayList<Double> positions) {
        this.positions = new double[positions.size()];

        for (int i = 0; i < this.positions.length; i++) {
            this.positions[i] = positions.get(i).doubleValue();
        }
    }
}

public class MainFrame extends javax.swing.JFrame {
    static ArrayList<Double[]> data = new ArrayList<>();
    static HashMap<String, Amino_Acid> hydrophobicity = new HashMap<>();
    static ArrayList<Amino_Acid_Sequence> sequences = new ArrayList<>();

    //static ArrayList<double[]> averages = new ArrayList<>();
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        Hashtable labelTable = new Hashtable();
        cmbSlideLength.setSelectedIndex(8);
        labelTable.put(new Integer(5), new JLabel("0.5"));
        labelTable.put(new Integer(10), new JLabel("1.0"));
        labelTable.put(new Integer(15), new JLabel("1.5"));
        labelTable.put(new Integer(20), new JLabel("2.0"));
        labelTable.put(new Integer(25), new JLabel("2.5"));
        sldThreshold.setLabelTable(labelTable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flechFasta = new javax.swing.JFileChooser();
        flechSave = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        sldThreshold = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarInput = new javax.swing.JTextArea();
        btnUploadFasta = new javax.swing.JButton();
        btnGeneratePlot = new javax.swing.JButton();
        cmbSlideLength = new javax.swing.JComboBox<>();
        cmbScale = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sldThreshold.setMajorTickSpacing(5);
        sldThreshold.setMaximum(25);
        sldThreshold.setMinimum(5);
        sldThreshold.setMinorTickSpacing(1);
        sldThreshold.setPaintLabels(true);
        sldThreshold.setPaintTicks(true);
        sldThreshold.setSnapToTicks(true);
        sldThreshold.setValue(10);

        txtarInput.setColumns(20);
        txtarInput.setRows(5);
        jScrollPane1.setViewportView(txtarInput);

        btnUploadFasta.setText("Upload Fasta");
        btnUploadFasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadFastaActionPerformed(evt);
            }
        });

        btnGeneratePlot.setText("Generate Plot");
        btnGeneratePlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePlotActionPerformed(evt);
            }
        });

        cmbSlideLength.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "7", "9", "11", "13", "15", "17", "19", "21", "23", "25", "27", "29", "31", "33", "35", "37", "39", "41", "43", "45", "47", "49", "51" }));

        cmbScale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kyte-Doolittle", "Hopp-Woods", "Cornette", "Eisenberg", "Rose", "Janin", "Engelmen GES", " " }));

        jLabel1.setText("Sliding Window Length");

        jLabel2.setText("Hydrophobicity Scale");

        jLabel3.setText("Hydrophobicity Value Threshold");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUploadFasta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGeneratePlot))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sldThreshold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cmbSlideLength, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbScale, 0, 200, Short.MAX_VALUE))
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnReset)
                                        .addContainerGap())))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuit)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUploadFasta)
                    .addComponent(btnGeneratePlot)
                    .addComponent(btnQuit))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSlideLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadFastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadFastaActionPerformed
        flechFasta.showOpenDialog(jScrollPane1);
        File fasta = flechFasta.getSelectedFile();
        String fastaContents = "";

        try {
            fastaContents = readFasta(fasta);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtarInput.setText(fastaContents);
    }//GEN-LAST:event_btnUploadFastaActionPerformed

    private void btnGeneratePlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePlotActionPerformed
        readInputForSequences(txtarInput.getText());
        boolean execute = true;
        execute = true;
        
        for (int i = 0; i < sequences.size(); i++) {
            if(sequences.get(i).sequence.size() < Integer.parseInt(cmbSlideLength.getSelectedItem().toString())) {
                execute = false;
                break;
            }
        }
        
        if(execute == true) {
            if (sequences.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No valid sequence in input");
            }
            
            else {
                getAverages(Integer.parseInt(cmbSlideLength.getSelectedItem().toString()), cmbScale.getSelectedIndex());
                displayPlot(sldThreshold.getValue(), Integer.parseInt(cmbSlideLength.getSelectedItem().toString()));
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Input cannot be smaller than sliding window length");
        }
    }//GEN-LAST:event_btnGeneratePlotActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        sequences.removeAll(sequences);
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnQuitActionPerformed

    public String readFasta(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String contents = "";

        while (scan.hasNextLine()) {
            contents += scan.nextLine() + "\n";
        }

        return contents;
    }

    public static void readInputForSequences(String input) {
        ArrayList<Amino_Acid_Sequence> removed = new ArrayList<>();
        Scanner scan = new Scanner(input);
        String line, sequenceString = "", removedString = "";
        int ignored = 0;
        boolean ignoredBool = false;

        while (scan.hasNextLine()) {

            line = scan.nextLine();

            if (!line.isEmpty()) {

                if ((line.contains(">"))) {
                    sequences.add(new Amino_Acid_Sequence());
                    sequences.get(sequences.size() - 1).setDescription(line);
                } else {
                    if(!sequences.isEmpty()){
                        if(sequences.get(sequences.size() - 1).getSequenceString().isEmpty()) {
                            sequenceString += line;
                        }
                        else {
                            ignoredBool = true;
                        }
                    }
                    else
                        ignoredBool = true;
                }
            } else {
                if (ignoredBool == true) {
                    ignored++;
                    ignoredBool = false;
                }

                if(!sequences.isEmpty()) {
                    if (sequenceString.contains("B") ||
                        sequenceString.contains("J") ||
                        sequenceString.contains("O") ||
                        sequenceString.contains("U") ||
                        sequenceString.contains("X") ||
                        sequenceString.contains("Z")) {
                            
                        removed.add(sequences.get(sequences.size() - 1));
                        sequences.remove(sequences.get(sequences.size() - 1));
                    }
                    
                    else {
                        sequences.get(sequences.size() - 1).setSequence(sequenceString.toUpperCase());
                    }
                }
                sequenceString = "";
            }
        }

        if (!sequenceString.isEmpty()) {
            if (sequenceString.contains("B") ||
                sequenceString.contains("J") ||
                sequenceString.contains("O") ||
                sequenceString.contains("U") ||
                sequenceString.contains("X") ||
                sequenceString.contains("Z")) {

                removed.add(sequences.get(sequences.size() - 1));
                sequences.remove(sequences.get(sequences.size() - 1));
            }

            else {
                sequences.get(sequences.size() - 1).setSequence(sequenceString.toUpperCase());
            }
            sequenceString = "";
        }       
        
        if (ignoredBool == true) {
            ignored++;
            ignoredBool = false;
        }
        
        for (int i = 0; i < removed.size(); i++) {
            removedString += removed.get(i).getDescription().substring(removed.get(i).getDescription().indexOf("|") + 1, removed.get(i).getDescription().lastIndexOf("|")) + "\n";
        }
        
        if(!removed.isEmpty())
            JOptionPane.showMessageDialog(null, "Sequence(s):\n" + removedString + "\nwere removed because they contain invalid Amino Acid symbols");
        if(ignored > 0)
            JOptionPane.showMessageDialog(null, ignored + " input(s) were ignored because they were not valid FASTA formats");
    }

    public static void getAverages(int slidingWindow, int scaleUsed) {
        ArrayList<Double> averagesList = new ArrayList<>();
        ArrayList<Double> positionsList = new ArrayList<>();
        double average = 0;

        for (int i = 0; i < sequences.size(); i++) {
            for (int j = 0; j < sequences.get(i).getSequence().size() - (slidingWindow - 1); j++) {
                int l = j;

                for (int k = 0; k < slidingWindow; k++, l++) {
                    average += sequences.get(i).getSequence().get(l).getHydrophobicity()[scaleUsed];
                }

                average /= slidingWindow;
                averagesList.add(average);
                average = 0;

                positionsList.add((j + ((slidingWindow + 1.0) / 2.0)));
            }

            sequences.get(i).setPositions(positionsList);
            sequences.get(i).setAverages(averagesList);
            averagesList.removeAll(averagesList);
            positionsList.removeAll(positionsList);
        }
    }

    public static void displayPlot(double threshold, int sliderWindow) {
        ArrayList<XYChart> charts = new ArrayList<>();
        threshold /= 10;
        for (int i = 0; i < sequences.size(); i++) {
            ArrayList<Double[]> hydrophobicSequences = new ArrayList<>();
            ArrayList<Double> hydrophobicIndies = new ArrayList<>();
            ArrayList<Double[]> dataList = new ArrayList<>();
            double[] thresholdXData = new double[sequences.get(i).getSequence().size()];
            double[] thresholdYData = new double[thresholdXData.length];
            double[] hydrophobicYData;
            double max = -99999;

            for (int j = (int) sequences.get(i).positions[0]; j < thresholdXData.length; j++) {
                thresholdXData[j] = j;
            }

            Arrays.fill(thresholdYData, threshold);

            for (int j = 0; j < sequences.get(i).averages.length; j++) {
                if (sequences.get(i).averages[j] > threshold) {
                    if (sequences.get(i).averages[j] > max) {
                        max = sequences.get(i).averages[j] + 0.5;
                    }

                    hydrophobicIndies.add(sequences.get(i).positions[j]);
                } else {
                    if (hydrophobicIndies.size() >= sliderWindow) {
                        Double[] hydrophobicArray = new Double[hydrophobicIndies.size()];

                        for (int k = 0; k < hydrophobicArray.length; k++) {
                            hydrophobicArray[k] = hydrophobicIndies.get(k);
                        }
                        
                        dataList.add(new Double[] {hydrophobicArray[0], hydrophobicArray[hydrophobicArray.length - 1]});
                        hydrophobicSequences.add(hydrophobicArray);
                        sequences.get(i).segments++;
                    }

                    hydrophobicIndies.removeAll(hydrophobicIndies);
                }
            }

            if (hydrophobicIndies.size() >= sliderWindow) {
                Double[] hydrophobicArray = new Double[hydrophobicIndies.size()];

                for (int k = 0; k < hydrophobicArray.length; k++) {
                    hydrophobicArray[k] = hydrophobicIndies.get(k);
                }

                hydrophobicSequences.add(hydrophobicArray);
                sequences.get(i).segments++;
            }

            hydrophobicIndies.removeAll(hydrophobicIndies);

            charts.add(new XYChartBuilder().width(800).height(400).title(sequences.get(i).getDescription().substring(sequences.get(i).getDescription().indexOf("|") + 1, sequences.get(i).getDescription().lastIndexOf("|"))).xAxisTitle("Index Position").yAxisTitle("Average Hydrophobicity").build());

            charts.get(i).addSeries("Hydrophobicity", sequences.get(i).positions, sequences.get(i).averages);
            charts.get(i).addSeries("Hydrophobicity Threshold", thresholdXData, thresholdYData).setMarker(new org.knowm.xchart.style.markers.None());
            
            hydrophobicYData = new double[2];

            Arrays.fill(hydrophobicYData, max);

            for (int j = 0; j < hydrophobicSequences.size(); j++) {
                charts.get(i).addSeries(hydrophobicSequences.get(j)[0].intValue() + " - " + hydrophobicSequences.get(j)[hydrophobicSequences.get(j).length - 1].intValue(), DoubleTodouble(hydrophobicSequences.get(j)), hydrophobicYData).setMarker(new org.knowm.xchart.style.markers.None());
                data.add(new Double[]{hydrophobicSequences.get(j)[0], hydrophobicSequences.get(j)[hydrophobicSequences.get(j).length - 1]});
            }
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // Create and set up the window.
                JFrame frame = new JFrame("Hydrophobicity Charts");
                frame.setLayout(new GridLayout(1, 0));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JScrollPane scroll = new JScrollPane();
                JPanel mainPanel = new JPanel();
                JButton export = new JButton("Export");
                
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
                scroll.setVisible(true);
                export.setVisible(true);

                // chart
                for (int i = 0; i < charts.size(); i++) {
                    JPanel chartPanel = new JPanel();
                    JPanel subPanel = new JPanel();
                    JButton save = new JButton("Download");
                    
                    
                    chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.Y_AXIS));
                    chartPanel.add(new XChartPanel<XYChart>(charts.get(i)));
                    
                    save.setVisible(true);
                    
                    subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
                    subPanel.add(chartPanel);
                    subPanel.add(save);
                    
                    scroll = new JScrollPane(mainPanel);
                    
                    save.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            savePicture(chartPanel);
                        }
                    });
                    
                    mainPanel.add(subPanel);
                }
                
                export.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        export(data);
                    }
                });
                mainPanel.add(export);
                
                frame.add(scroll);

                // Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
    public static void export(ArrayList<Double[]> data) {
        
        try {
            JFileChooser flechFasta = new JFileChooser();
            flechFasta.setCurrentDirectory(new java.io.File("."));
            flechFasta.setDialogTitle("Save as text");
            
            if (flechFasta.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                String filename = flechFasta.getSelectedFile().getCanonicalPath();
                System.out.println("file: " + filename);
                FileWriter write = new FileWriter(filename);
            
                BufferedWriter writer = new BufferedWriter(write);
                
                int j = 0;
                for (int i = 0; i < sequences.size(); i++) {
                    writer.write(sequences.get(i).getDescription().substring(sequences.get(i).getDescription().indexOf("|") + 1, sequences.get(i).getDescription().lastIndexOf("|")));
                    writer.write("   #" + sequences.get(i).segments + "\t\t\t");
                    for (int k = 0; k < sequences.get(i).segments; j++, k++) {
                        writer.write(data.get(j)[0].intValue() + "\t\t\t\t" + data.get(j)[1].intValue() + "\t\t\t\t\t");
                    }
                    writer.newLine();
                }
                
                writer.close();
            } else {
                System.out.println("No Selection ");
            }
        } catch (IOException ioe) {
            System.out.println("write: " + ioe.getMessage());
        }
//        flechSave.showSaveDialog(jScrollPane2);
//        File saveFile = flechSave.getSelectedFile();
//        String filename = saveFile.getAbsolutePath();
//        
//        try {
//            FileWriter write = new FileWriter(filename);
//            
//            BufferedWriter writer = new BufferedWriter(write);
//            
//            writer.write(txtarDecoded.getText());
//            
//            writer.close();
//        } catch (IOException ex) {
//            Logger.getLogger(dnaprocessing.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public static void savePicture(Component panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        panel.paint(g2);
        g2.dispose();
        try {
            JFileChooser flechFasta = new JFileChooser();
            flechFasta.setCurrentDirectory(new java.io.File("."));
            flechFasta.setDialogTitle("Save as Image");
            

            if (flechFasta.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                String filename = flechFasta.getSelectedFile().getCanonicalPath();
                System.out.println("file: " + filename);
                ImageIO.write(bi, "jpg", new File(filename + ".jpg"));
//                frame.hide();
            } else {
                System.out.println("No Selection ");
            }
        } catch (IOException ioe) {
            System.out.println("write: " + ioe.getMessage());
        }
    }

    public static double[] DoubleTodouble(Double[] doubleClass) {
        double[] doublePrimitive = new double[] {doubleClass[0], doubleClass[doubleClass.length - 1]};
//        for (int k = 0; k < doublePrimitive.length; k++) {
//            doublePrimitive[k] = doubleClass[k].doubleValue();
//        }

        return doublePrimitive;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeneratePlot;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUploadFasta;
    private javax.swing.JComboBox<String> cmbScale;
    private javax.swing.JComboBox<String> cmbSlideLength;
    private javax.swing.JFileChooser flechFasta;
    private javax.swing.JFileChooser flechSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider sldThreshold;
    private javax.swing.JTextArea txtarInput;
    // End of variables declaration//GEN-END:variables

}
