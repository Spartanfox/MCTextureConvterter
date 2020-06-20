/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mctextureconverter.UI;

import java.io.File;
import javax.swing.JFileChooser;
import mctextureconverter.ColorFilter;
import mctextureconverter.Globals;
import mctextureconverter.Helpers;
import mctextureconverter.TextureConvert;

/**
 *
 * @author benro
 */
public class ConvertFrame extends javax.swing.JFrame {

    /**
     * Creates new form Convert
        java    red  :roughness
        java    green:metallic
        java    blue :emission
        bedrock red  :metallic
        bedrock green:emission
        bedrock blue :roughness
     */
    File original;
    File destination;
    
    String[] resolutions = {"8","16","32","64","128","256","512","1024","2048"};
    String[] channels = {"None","Red","Green","Blue","Alpha"};
    
    TextureConvert diffuseFilter;
    TextureConvert normalFilter;
    TextureConvert materialFilter;
    
    public ConvertFrame() {
        initComponents();
        Globals.console = this.console;
        Globals.progress = this.progress;
    }
    public void setFilters(){
        
        //color filters a bit shit its not a color filter its just an int filter I still need three to make a color
        diffuseFilter = new TextureConvert(
                Integer.parseInt(resolutions[this.diffuseRes.getSelectedIndex()]),
                ColorFilter.red,ColorFilter.green,ColorFilter.blue
        );
        
        normalFilter = new TextureConvert(
                Integer.parseInt(resolutions[this.normalRes.getSelectedIndex()]),
                ColorFilter.red,(normalFlip.isSelected())?ColorFilter.greenInverted:ColorFilter.green,ColorFilter.blue
        );
        
        ColorFilter roughness = new ColorFilter(
                roughnessChannel.getSelectedIndex(),
                (int)roughnessInMin.getValue(),
                (int)roughnessInMax.getValue(),
                (int)roughnessOutMin.getValue(),
                (int)roughnessOutMax.getValue()
        );
        
        ColorFilter metallic = new ColorFilter(
                metallicChannel.getSelectedIndex(),
                (int)metallicInMin.getValue(),
                (int)metallicInMax.getValue(),
                (int)metallicOutMin.getValue(),
                (int)metallicOutMax.getValue()
        );
        
        ColorFilter emission = new ColorFilter(
                emissionChannel.getSelectedIndex(),
                (int)emissionInMin.getValue(),
                (int)emissionInMax.getValue(),
                (int)emissionOutMin.getValue(),
                (int)emissionOutMax.getValue()
        );
        
        materialFilter = new TextureConvert(
                Integer.parseInt(resolutions[this.materialRes.getSelectedIndex()]),
                roughness,emission,metallic
        );        
    }
    
    public void updateBedrockDir(){
        destination = new File(original.getAbsoluteFile()+"_bedrock");
        bedrockDir.setText(destination.getAbsolutePath());
        Helpers.print(console,"Origin destination changed to: "+destination.getAbsolutePath());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javaDir = new javax.swing.JTextField();
        javaDirBrowse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        convertButton = new javax.swing.JButton();
        bedrockDir = new javax.swing.JTextField();
        BedrockDirBrowse = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();
        metallicChannel = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        metallicInMin = new javax.swing.JSpinner();
        metallicInMax = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        metallicOutMin = new javax.swing.JSpinner();
        metallicOutMax = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        roughnessInMin = new javax.swing.JSpinner();
        emissionChannel = new javax.swing.JComboBox<>();
        roughnessInMax = new javax.swing.JSpinner();
        emissionOutMin = new javax.swing.JSpinner();
        roughnessOutMin = new javax.swing.JSpinner();
        emissionOutMax = new javax.swing.JSpinner();
        roughnessOutMax = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emissionInMax = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        roughnessChannel = new javax.swing.JComboBox<>();
        emissionInMin = new javax.swing.JSpinner();
        autoConfigButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        normalFlip = new javax.swing.JCheckBox();
        normalRes = new javax.swing.JComboBox<>();
        materialRes = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        diffuseRes = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java PBR to Bedrock RTX texture converter");

        javaDir.setText("Choose the directory of your java textures");
        javaDir.setToolTipText("Example C:/Minecraft/TexturePacks/Blocks");
        javaDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaDirActionPerformed(evt);
            }
        });

        javaDirBrowse.setText("Browse");
        javaDirBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaDirBrowseActionPerformed(evt);
            }
        });

        console.setColumns(20);
        console.setLineWrap(true);
        console.setRows(5);
        console.setWrapStyleWord(true);
        console.setFocusable(false);
        jScrollPane1.setViewportView(console);

        convertButton.setText("Convert");
        convertButton.setEnabled(false);
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });

        bedrockDir.setText("Choose the destination folder");
        bedrockDir.setToolTipText("Example C:/bedrock_blocks");
        bedrockDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedrockDirActionPerformed(evt);
            }
        });

        BedrockDirBrowse.setText("Browse");
        BedrockDirBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BedrockDirBrowseActionPerformed(evt);
            }
        });

        metallicChannel.setModel(new javax.swing.DefaultComboBoxModel<>(channels));
        metallicChannel.setSelectedIndex(2);
        metallicChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metallicChannelActionPerformed(evt);
            }
        });

        jLabel1.setText("Material properties");

        jLabel6.setText("Metallic channel");

        metallicInMax.setValue(255);

        jLabel3.setText("to");

        metallicOutMax.setValue(255);

        jLabel7.setText("Emission channel");

        emissionChannel.setModel(new javax.swing.DefaultComboBoxModel<>(channels));
        emissionChannel.setSelectedIndex(3);
        emissionChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emissionChannelActionPerformed(evt);
            }
        });

        roughnessInMax.setValue(255);

        roughnessOutMin.setValue(255);

        emissionOutMax.setValue(255);

        roughnessOutMax.setValue(0);

        jLabel4.setText("to");

        jLabel2.setText("to");

        emissionInMax.setValue(255);

        jLabel5.setText("Roughness channel");

        roughnessChannel.setModel(new javax.swing.DefaultComboBoxModel<>(channels));
        roughnessChannel.setSelectedIndex(1);
        roughnessChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roughnessChannelActionPerformed(evt);
            }
        });

        autoConfigButton.setText("Auto configure");
        autoConfigButton.setEnabled(false);
        autoConfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoConfigButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Normal properties");

        normalFlip.setSelected(true);
        normalFlip.setText("Flip green channel");

        normalRes.setMaximumRowCount(9);
        normalRes.setModel(new javax.swing.DefaultComboBoxModel<>(resolutions));
        normalRes.setSelectedIndex(7);

        materialRes.setMaximumRowCount(9);
        materialRes.setModel(new javax.swing.DefaultComboBoxModel<>(resolutions));
        materialRes.setSelectedIndex(5);

        jLabel9.setText("Material resolution cap");

        jLabel10.setText("Normal resolution cap");

        jLabel11.setText("Diffuse properties");

        jLabel12.setText("Diffuse resolution cap");
        jLabel12.setMaximumSize(new java.awt.Dimension(103, 14));
        jLabel12.setMinimumSize(new java.awt.Dimension(103, 14));
        jLabel12.setPreferredSize(new java.awt.Dimension(103, 14));

        diffuseRes.setMaximumRowCount(9);
        diffuseRes.setModel(new javax.swing.DefaultComboBoxModel<>(resolutions));
        diffuseRes.setSelectedIndex(6);

        jLabel13.setText("Remap values");

        jLabel14.setText("Remap values");

        jLabel15.setText("Remap values");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bedrockDir, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(javaDir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(javaDirBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BedrockDirBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(convertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emissionChannel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metallicChannel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(normalFlip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(autoConfigButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(normalRes, 0, 149, Short.MAX_VALUE)
                            .addComponent(diffuseRes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(materialRes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roughnessChannel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(roughnessInMin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roughnessInMax)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roughnessOutMin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roughnessOutMax))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emissionInMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emissionInMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emissionOutMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emissionOutMax))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metallicInMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metallicInMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metallicOutMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metallicOutMax)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(javaDir)
                    .addComponent(javaDirBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bedrockDir)
                    .addComponent(BedrockDirBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(diffuseRes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(normalFlip)
                        .addComponent(normalRes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(autoConfigButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(materialRes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roughnessChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(roughnessInMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roughnessInMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roughnessOutMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roughnessOutMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metallicChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metallicInMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(metallicInMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(metallicOutMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(metallicOutMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emissionChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emissionInMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emissionInMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emissionOutMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emissionOutMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void javaDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaDirActionPerformed
        System.out.println("Something changed");
        original = new File(javaDir.getText());
        if(original.exists()&&original.isDirectory()){
            convertButton.setEnabled(true);
            updateBedrockDir();
            Helpers.print(console,"Origin destination changed to: "+original.getAbsolutePath());
        }else{
            Helpers.print(console,"Invalid directory in java resource path");
            convertButton.setEnabled(false);
        }
    }//GEN-LAST:event_javaDirActionPerformed

    private void javaDirBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaDirBrowseActionPerformed
        JFileChooser selection = new JFileChooser(Globals.defaultPath);
        Helpers.print(console,"Opening directory selection");
        selection.setDialogTitle("Choose a directory to convert");
	selection.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = selection.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
                if (selection.getSelectedFile().exists()&&selection.getSelectedFile().isDirectory()) {
                    convertButton.setEnabled(true);
                    Helpers.print(console,"Set directory to: "+selection.getSelectedFile());
                    javaDir.setText(selection.getSelectedFile().getPath());
                    original = selection.getSelectedFile();
                    updateBedrockDir();
                }else{
                    convertButton.setEnabled(false);
                    Helpers.print(console,"Invalid selection");
                    original = null;
                }
        }else{
            convertButton.setEnabled(false);
            original = null;
            Helpers.print(console,"Action canceled");
        }
    }//GEN-LAST:event_javaDirBrowseActionPerformed

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
        setFilters();
        Thread convertion = Helpers.convertJavaToBedrock(original, destination,diffuseFilter,normalFilter,materialFilter);
        convertion.start();
        
    }//GEN-LAST:event_convertButtonActionPerformed

    private void bedrockDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedrockDirActionPerformed

    }//GEN-LAST:event_bedrockDirActionPerformed

    private void BedrockDirBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BedrockDirBrowseActionPerformed
        JFileChooser selection = new JFileChooser(Globals.defaultPath);
        Helpers.print(console,"Opening directory selection");
        selection.setDialogTitle("Choose a directory to convert");
	selection.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = selection.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
                if (selection.getSelectedFile().exists()&&selection.getSelectedFile().isDirectory()) {
                    convertButton.setEnabled(true);
                    Helpers.print(console,"Set directory to: "+selection.getSelectedFile());
                    javaDir.setText(selection.getSelectedFile().getPath());
                    original = selection.getSelectedFile();
                    updateBedrockDir();
                }else{
                    convertButton.setEnabled(false);
                    Helpers.print(console,"Invalid selection");
                    original = null;
                }
        }else{
            convertButton.setEnabled(false);
            original = null;
            Helpers.print(console,"Action canceled");
        }
    }//GEN-LAST:event_BedrockDirBrowseActionPerformed

    private void metallicChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metallicChannelActionPerformed
        Helpers.print(console,"Metallic channel set to "+metallicChannel.getSelectedItem());
    }//GEN-LAST:event_metallicChannelActionPerformed

    private void emissionChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emissionChannelActionPerformed
        Helpers.print(console,"Emission channel set to "+emissionChannel.getSelectedItem());
    }//GEN-LAST:event_emissionChannelActionPerformed

    private void roughnessChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roughnessChannelActionPerformed
        Helpers.print(console,"Roughness channel set to "+roughnessChannel.getSelectedItem());
    }//GEN-LAST:event_roughnessChannelActionPerformed

    private void autoConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoConfigButtonActionPerformed
        //NEED TO IMPLEMENT THE SCANNER TO GET THE MARGINS OF THE VALUES
    }//GEN-LAST:event_autoConfigButtonActionPerformed
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BedrockDirBrowse;
    private javax.swing.JButton autoConfigButton;
    private javax.swing.JTextField bedrockDir;
    private javax.swing.JTextArea console;
    private javax.swing.JButton convertButton;
    private javax.swing.JComboBox<String> diffuseRes;
    private javax.swing.JComboBox<String> emissionChannel;
    private javax.swing.JSpinner emissionInMax;
    private javax.swing.JSpinner emissionInMin;
    private javax.swing.JSpinner emissionOutMax;
    private javax.swing.JSpinner emissionOutMin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField javaDir;
    private javax.swing.JButton javaDirBrowse;
    private javax.swing.JComboBox<String> materialRes;
    private javax.swing.JComboBox<String> metallicChannel;
    private javax.swing.JSpinner metallicInMax;
    private javax.swing.JSpinner metallicInMin;
    private javax.swing.JSpinner metallicOutMax;
    private javax.swing.JSpinner metallicOutMin;
    private javax.swing.JCheckBox normalFlip;
    private javax.swing.JComboBox<String> normalRes;
    private javax.swing.JProgressBar progress;
    private javax.swing.JComboBox<String> roughnessChannel;
    private javax.swing.JSpinner roughnessInMax;
    private javax.swing.JSpinner roughnessInMin;
    private javax.swing.JSpinner roughnessOutMax;
    private javax.swing.JSpinner roughnessOutMin;
    // End of variables declaration//GEN-END:variables
}
