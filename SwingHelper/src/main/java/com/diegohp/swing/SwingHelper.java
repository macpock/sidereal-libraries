
package com.diegohp.swing;

import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/**
 * This class brings some shortcuts of Swing User-Interface components.
 *
 * @author diegohp (Diego Hernandez Perez) - <a href="mailto:hp.diego@gmail.com">hp.diego@gmail.com</a>
 * @version 1.1
 */
public final class SwingHelper {
    
    /**
     * Setting the look and feel to be the System one as default.
     */
    static{
        SwingHelper.setLookAndFeel(LookAndFeel.SYSTEM);
    }
    
    /**
     * Enum listing the look and feel types.
     * @since 1.1
     */
    public enum LookAndFeel{
        /**
         * The main default Java look and feel. Present on all OS.
         */
        METAL("javax.swing.plaf.metal.MetalLookAndFeel"),
        /**
         * One of the default Java look and feels. Present on all OS.
         */
        NIMBUS("javax.swing.plaf.nimbus.NimbusLookAndFeel"), 
        /**
         * One of the default Java look and feels. Present on all OS.
         */
        MOTIF("com.sun.java.swing.plaf.motif.MotifLookAndFeel"),
        /**
         * Windows look and feel, the theme depends on the version (XP, Vista, 7, 8).
         * Only present on Windows OS.
         */
        WINDOWS("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"),
        /**
         * A classic windows look ad feel. Only present on Windows OS.
         */
        WINDOWS_CLASSIC("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"),
        /**
         * Mac OSX look and feel. Only present on MAC OS.
         */
        MAC("com.apple.laf.AquaLookAndFeel"),
        /**
         * GTK+ look and feel. Present on all OS except Windows.
         */
        GTK("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"),
        /**
         * Uses the native look and feel of the host OS.
         */
        SYSTEM(UIManager.getSystemLookAndFeelClassName());
        
        private String lookAndFeelClass;
        
        private LookAndFeel(String lookAndFeelClass){
            this.lookAndFeelClass = lookAndFeelClass;
        }

        /**
         * @return the lookAndFeel
         */
        public String getLookAndFeelClass() {
            return lookAndFeelClass;
        }
    }
    
    /**
     * Enum listing the Metal themes..
     * @since 1.1
     */
    public enum MetalTheme{
        DEFAULT_METAL,
        OCEAN;
        
        private MetalTheme(){}
    }
    
    /**
     * Set the look and feel of the current app.
     * <p/>
     * If you want to change the look and feel once the UI was displayed, invoke the following methods for each top-level container:
     * <br/>
     * <code>
     * SwingUtilities.updateComponentTreeUI(yourFrame);<br/>
     * yourFrame.pack();
     * </code>
     * 
     * @param lookAndFeel One of the options listed on {@link LookAndFeel}.
     */
    public static void setLookAndFeel(LookAndFeel lookAndFeel){
        try {
            javax.swing.UIManager.setLookAndFeel(lookAndFeel.getLookAndFeelClass());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SwingHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SwingHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SwingHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SwingHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Set the theme for the Metal look and feel.<br/>
     * This method calls {@link #setLookAndFeel(com.diegohp.swing.SwingHelper.LookAndFeel)} with {@link LookAndFeel#METAL} to set the Metal look and feel.<br/>
     * The Metal look  and feel is required to use these themes.
     * 
     * @param metalTheme One of the options listed on {@link MetalTheme}.
     */
    public static void setMetalTheme(MetalTheme metalTheme){
        SwingHelper.setLookAndFeel(LookAndFeel.METAL);
        if(metalTheme == MetalTheme.DEFAULT_METAL) MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        if(metalTheme == MetalTheme.OCEAN) MetalLookAndFeel.setCurrentTheme(new OceanTheme());
    }
    
    /**
     * Centers a {@link Window} at the center of the screen.<br/>
     * Windows like {@link JDialog} and {@link JFrame} (and others) that extend from {@link Window} applies for this method.
     * 
     * @param window 
     */
    public static void centerWindow(Window window){
         window.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - window.getWidth()/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - window.getHeight()/2);
    }

    /**
     * Displays a {@link JOptionPane} as an error message.
     *
     * @param title The title of the dialog.
     * @param message The message inside the dialog.
     */
    public static void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a {@link JOptionPane} as a warning message.
     *
     * @param title The title of the dialog.
     * @param message The message inside the dialog.
     */
    public static void showWarningMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Displays a {@link JOptionPane} as an information message.
     *
     * @param title The title of the dialog.
     * @param message The message inside the dialog.
     */
    public static void showInformationMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a {@link JOptionPane} as an Input Dialog asking for a required text.
     *
     * @param title The title of the dialog.
     * @return The text written by the user.
     */
    public static String askForRequiredTextUsingInputDialog(String title, String message) {
        String text = null;
        while (text == null || text.trim().equals("")) {
            text = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
        }
        return text;
    }
    
    /**
     * Displays a {@link JOptionPane} as a Confirm Dialog with YES and NO buttons.
     * 
     * @param title The title of the Dialog.
     * @param message The message of the Dialog.
     * @return "yes" or "no" if clicked on the respective buttons.
     */
    public static String showConfirmationDialogWithYesNoButtons(String title, String message){
        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION) return "yes";
        if(result == JOptionPane.NO_OPTION) return "no";
        return null;
    }
    
    /**
     * Displays a {@link JOptionPane} as a Confirm Dialog with YES, NO and CANCEL buttons.
     * 
     * @param title The title of the Dialog.
     * @param message The message of the Dialog.
     * @return "yes" or "no" or "cancel" if clicked on the respective buttons.
     */
    public static String showConfirmationDialogWithYesNoCancelButtons(String title, String message){
        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION) return "yes";
        if(result == JOptionPane.NO_OPTION) return "no";
        if(result == JOptionPane.CANCEL_OPTION) return "cancel";
        return null;
    }
    
    /**
     * Displays a {@link JOptionPane} as a Confirm Dialog with OK and CANCEL buttons.
     * 
     * @param title The title of the Dialog.
     * @param message The message of the Dialog.
     * @return "ok" or "cancel" if clicked on the respective buttons.
     */
    public static String showConfirmationDialogWithOkCancelButtons(String title, String message){
        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.OK_OPTION) return "ok";
        if(result == JOptionPane.CANCEL_OPTION) return "cancel";
        return null;
    }

    /**
     * Displays a {@link JFileChooser} to select a directory.
     *
     * @param title The title of the dialog.
     * @param startDirectory The directory where the dialog is initialed opened.
     * @return The {@link File} selected, returns null if no directory was selected.
     */
    public static File chooseDirectory(String title, String startDirectory) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle(title);

        if (startDirectory != null && !startDirectory.trim().equals("")) {
            chooser.setCurrentDirectory(new File(startDirectory));
        }

        int status = chooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }
    
    /**
     * Displays a {@link JFileChooser} to select a directory.
     *
     * @param title The title of the dialog.
     * @param startDirectory The directory where the dialog is initialed opened.
     * @return The {@link File} selected, returns null if no directory was selected.
     */
    public static File chooseDirectory(String title, File startDirectory) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle(title);

        if (startDirectory != null) {
            chooser.setCurrentDirectory(startDirectory);
        }

        int status = chooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }

    /**
     * Displays a {@link JFileChooser} to select a directory.
     *
     * @param title The title of the dialog.
     * @return The {@link File} selected, returns null if no directory was selected.
     */
    public static File chooseDirectory(String title) {
        return chooseDirectory(title, "");
    }

    /**
     * Displays a {@link JFileChooser} to select a file.
     *
     * @param title The title of the dialog.
     * @param startDirectory The directory where the dialog is initialed opened.
     * @param fileExtension File extension to filter each content of the opened
     * directories. Example ".xml".
     * @param startFile The preselected file where the dialog is initialed opened.
     * @return The {@link File} object selected, returns null if no file was selected.
     */
    public static File chooseFile(String title, String startDirectory, final String fileExtension, String startFile) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setDialogTitle(title);

        if (fileExtension != null && !fileExtension.trim().equals("")) {
            FileFilter filter = new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() || pathname.getName().endsWith(fileExtension);
                }

                @Override
                public String getDescription() {
                    return "(" + fileExtension + ")";
                }
            };

            chooser.setFileFilter(filter);
        }

        if (startDirectory != null && !startDirectory.trim().equals("")) {
            chooser.setCurrentDirectory(new File(startDirectory));
        }

        if (startFile != null && !startFile.trim().equals("")) {
            chooser.setSelectedFile(new File(startFile));
        }

        int status = chooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }

    /**
     * Displays a {@link JFileChooser} to select a file.
     *
     * @param title The title of the dialog.
     * @param startDirectory The directory where the dialog is initialed opened.
     * @param fileExtension File extension to filter each content of the opened
     * directories. Example ".xml".
     * @return The {@link File} object selected, returns null if no file was
     * selected.
     */
    public static File chooseFile(String title) {
        return chooseFile(title, null, null, null);
    }

    /**
     * Displays a {@link JFileChooser} to select a file.
     *
     * @param title The title of the dialog.
     * @param fileExtension File extension to filter each content of the opened directories. Example ".xml".
     * @return The {@link File} object selected, returns null if no file was selected.
     */
    public static File chooseFile(String title, String fileExtension) {
        return chooseFile(title, null, fileExtension, null);
    }
}
