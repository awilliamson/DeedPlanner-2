/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wurmonline.deedplanner.forms;

import java.awt.Desktop;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import pl.wurmonline.deedplanner.util.Log;

/**
 *
 * @author Maciej
 */
public class NewVersionWindow extends javax.swing.JFrame {

    private static final int DOWNLOAD_BUFFER = 1024;
    
    private String releaseUrl;
    private String downloadUrl;
    
    public NewVersionWindow() {
        initComponents();
        try {
            ArrayList<Image> images = new ArrayList();
            images.add(ImageIO.read(Planner.class.getResourceAsStream("logoL.jpg")));
            images.add(ImageIO.read(Planner.class.getResourceAsStream("logoM.png")));
            images.add(ImageIO.read(Planner.class.getResourceAsStream("logoS.png")));
            setIconImages(images);
        } catch (IOException ex) {
            Log.err(ex);
        }
    }
    
    public void setChangelog(String changelog) {
        changelogPane.setText(changelog);
    }
    
    public void setCurrentVersion(String currentVersion) {
        currentVersionLabel.setText("Current version: " + currentVersion);
    }
    
    public void setNewVersion(String newVersion) {
        newVersionLabel.setText("New version: " + newVersion);
    }
    
    public void setReleaseUrl(String releaseUrl) {
        this.releaseUrl = releaseUrl;
    }
    
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        currentVersionLabel = new javax.swing.JLabel();
        newVersionLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        previewButton = new javax.swing.JButton();
        downloadButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        changelogPane = new javax.swing.JTextPane();
        skipUpdateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DeedPlanner Updater");
        setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Version is available!");

        currentVersionLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        currentVersionLabel.setText("Current Version: 2.8.7");

        newVersionLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        newVersionLabel.setText("New Version: 2.8.9");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Changelog");

        previewButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        previewButton.setText("See release information");
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });

        downloadButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        downloadButton.setText("Download and install");
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });

        progressBar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        progressBar.setMaximum(10000);
        progressBar.setToolTipText("");
        progressBar.setName(""); // NOI18N
        progressBar.setRequestFocusEnabled(false);
        progressBar.setStringPainted(true);

        jScrollPane2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        changelogPane.setContentType("text/html"); // NOI18N
        changelogPane.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        changelogPane.setText("<h1>DeedPlanner 2.8.9</h1>\n<h2>18.08.2017</h2>\n<ul>\n<li>Added possibility to place objects in tile corner</li>\n<li>Added highways</li>\n<li>Added new fence and parapet types added in 17 August 2017 Wurm Online update</li>\n<li>Added large storage unit</li>\n<li>Fixed hell horse missing texture bug</li>\n<li>Fixed few incorrect categories mappings</li>\n</ul>\n<h1>DeedPlanner 2.8.8</h1>\n<h2>18.07.2017</h2>\nFirst public release using <b>GitHub Releases</b> instead of <b>Dropbox</b>.\n<ul>\n<li>Added async texture loading</li>\n<li>Maps sent to Pastebin are now compressed before being sent - this enables use of Pastebin for much larger maps than before (GZIP compression with output converted to Base64)</li>\n<li>Slightly optimized mesh rendering by removing unnecessary OpenGL calls</li>\n<li>Fixed two incorrect bridge model mappings</li>\n<li>Fixed bug making models scaling work incorrectly for models with multiple meshes</li>\n<li>Fixed sandstone fences using wrong materials to build</li>\n<li>Fixed mappings for amphora and planter racks</li>\n</ul>");
        changelogPane.setToolTipText("");
        jScrollPane2.setViewportView(changelogPane);

        skipUpdateButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        skipUpdateButton.setText("Skip update");
        skipUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipUpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentVersionLabel)
                            .addComponent(newVersionLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skipUpdateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentVersionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newVersionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previewButton)
                    .addComponent(downloadButton)
                    .addComponent(skipUpdateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(releaseUrl));
            } catch (IOException | URISyntaxException ex) {
                Log.err(ex);
            }
        }
    }//GEN-LAST:event_previewButtonActionPerformed

    private void skipUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipUpdateButtonActionPerformed
        setVisible(false);
        new Loading();
    }//GEN-LAST:event_skipUpdateButtonActionPerformed

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        Thread downloadThread = new Thread(() -> {
            try {
                long lastDownloadUpdate = System.currentTimeMillis();
                long bytesDownloaded = 0;
                
                File temporaryDownloadFile = new File("NewRelease.zip");
                temporaryDownloadFile.deleteOnExit();
                
                URL url = new URL(downloadUrl);
                URLConnection conn = url.openConnection();
                long downloadSize = conn.getContentLengthLong();
                
                BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
                FileOutputStream fout = new FileOutputStream(temporaryDownloadFile);
                
                final byte data[] = new byte[DOWNLOAD_BUFFER];
                int count;
                while ((count = in.read(data, 0, DOWNLOAD_BUFFER)) != -1) {
                    fout.write(data, 0, count);

                    bytesDownloaded += DOWNLOAD_BUFFER;
                    if (System.currentTimeMillis() - lastDownloadUpdate > 1000) {
                        double downloadedPart = (double) bytesDownloaded / downloadSize;
                        int downloadProgress = (int) (10000 * downloadedPart);
                        String downloadPercent = new DecimalFormat("#.##").format(downloadedPart * 100) + "%";
                        SwingUtilities.invokeLater(() -> {
                            progressBar.setValue(downloadProgress);
                            progressBar.setString(downloadPercent);
                        });
                        
                        lastDownloadUpdate = System.currentTimeMillis();
                    }
                }
                
                in.close();
                fout.close();
                
                ZipFile zipFile = new ZipFile("NewRelease.zip");
                zipFile.extractAll("..");
                
                JOptionPane.showMessageDialog(null, "New DeedPlanner version downloaded and extracted to parent directory.", "DeedPlanner new version", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } catch (IOException | ZipException ex) {
                Log.err(ex);
            }
        });
        
        skipUpdateButton.setEnabled(false);
        downloadButton.setEnabled(false);
        downloadThread.start();
    }//GEN-LAST:event_downloadButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane changelogPane;
    private javax.swing.JLabel currentVersionLabel;
    private javax.swing.JButton downloadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel newVersionLabel;
    private javax.swing.JButton previewButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton skipUpdateButton;
    // End of variables declaration//GEN-END:variables
}