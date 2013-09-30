
package com.diegohp.swing;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 * @author diegohp (Diego Hernandez Perez) - <a href="mailto:hp.diego@gmail.com">hp.diego@gmail.com</a>
 */
public class SwingHelperTest {
    
    public SwingHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @org.junit.Test
    public void allTest(){
        testShowConfirmationDialogWithYesNoButtonsYES();
        testShowConfirmationDialogWithYesNoButtonsNO();
        testShowConfirmationDialogWithYesNoCancelButtonsYES();
        testShowConfirmationDialogWithYesNoCancelButtonsNO();
        testShowConfirmationDialogWithYesNoCancelButtonsCANCEL();
        testShowConfirmationDialogWithOkCancelButtonsOK();
        testShowConfirmationDialogWithOkCancelButtonsCANCEL();
        testAskForRequiredTextUsingInputDialog();
        testChooseDirectory_String_String();
        testChooseDirectory_String_File();
        testChooseDirectory_String();
        testChooseFile_4args();
        testChooseFile_String();
        testChooseFile_String_String();
        testChooseFile_3args();
        testSetLookAndFeel();
    }

    public void testShowConfirmationDialogWithYesNoButtonsYES(){
        System.out.println("showConfirmationDialogWithYesNoButtons");
        String title = "Click on a button to confirm";
        String message = "Click on YES button";
        String result = SwingHelper.showConfirmationDialogWithYesNoButtons(title, message);
        assertTrue("YES button was not clicked.", result.equals("yes"));
    }

    public void testShowConfirmationDialogWithYesNoButtonsNO(){
        System.out.println("showConfirmationDialogWithYesNoButtons");
        String title = "Click on a button to confirm";
        String message = "Click on NO button";
        String result = SwingHelper.showConfirmationDialogWithYesNoButtons(title, message);
        assertTrue("NO button was not clicked.", result.equals("no"));
    }
    
    public void testShowConfirmationDialogWithYesNoCancelButtonsYES(){
        System.out.println("showConfirmationDialogWithYesNoCancelButtons");
        String title = "Click on a button to confirm";
        String message = "Click on YES button";
        String result = SwingHelper.showConfirmationDialogWithYesNoCancelButtons(title, message);
        assertTrue("YES button was not clicked.", result.equals("yes"));
    }
    
    public void testShowConfirmationDialogWithYesNoCancelButtonsNO(){
        System.out.println("showConfirmationDialogWithYesNoCancelButtons");
        String title = "Click on a button to confirm";
        String message = "Click on NO button";
        String result = SwingHelper.showConfirmationDialogWithYesNoCancelButtons(title, message);
        assertTrue("NO button was not clicked.", result.equals("no"));
    }
    
    public void testShowConfirmationDialogWithYesNoCancelButtonsCANCEL(){
        System.out.println("showConfirmationDialogWithYesNoCancelButtons");
        String title = "Click on a button to confirm";
        String message = "Click on CANCEL button";
        String result = SwingHelper.showConfirmationDialogWithYesNoCancelButtons(title, message);
        assertTrue("CANCEL button was not clicked.", result.equals("cancel"));
    }
    
    public void testShowConfirmationDialogWithOkCancelButtonsOK(){
        System.out.println("showConfirmationDialogWithYesNoCancelButtons");
        String title = "Click on a button to confirm";
        String message = "Click on OK button";
        String result = SwingHelper.showConfirmationDialogWithOkCancelButtons(title, message);
        assertTrue("OK button was not clicked.", result.equals("ok"));
    }
    
    public void testShowConfirmationDialogWithOkCancelButtonsCANCEL(){
        System.out.println("showConfirmationDialogWithYesNoCancelButtons");
        String title = "Click on a button to confirm";
        String message = "Click on CANCEL button";
        String result = SwingHelper.showConfirmationDialogWithOkCancelButtons(title, message);
        assertTrue("CANCEL button was not clicked.", result.equals("cancel"));
    }

    public void testAskForRequiredTextUsingInputDialog() {
        System.out.println("askForRequiredTextUsingInputDialog");
        String result = SwingHelper.askForRequiredTextUsingInputDialog("Required text request", "Write something (not empty):");
        assertNotNull("Text was null", result);
        assertFalse("Text was empty", result.trim().equals(""));
    }

    public void testChooseDirectory_String_String() {
        System.out.println("chooseDirectory");
        String startDirectory = "target/test-classes/com/diegohp/swing/";
        File result = SwingHelper.chooseDirectory("Choose a folder", startDirectory);
        assertNotNull("Folder selected was null", result);
    }

    public void testChooseDirectory_String_File() {
        System.out.println("chooseDirectory");
        File startDirectory = new File("target/test-classes/com/diegohp/swing/");
        File result = SwingHelper.chooseDirectory("Choose a folder", startDirectory);
        assertNotNull("Folder selected was null", result);
    }

    public void testChooseDirectory_String() {
        System.out.println("chooseDirectory");
        File result = SwingHelper.chooseDirectory("Choose a folder");
        assertNotNull("Folder selected was null", result);
    }

    public void testChooseFile_4args() {
        System.out.println("chooseFile");
        String title = "Choose a file";
        String startDirectory = "target/test-classes/com/diegohp/swing/";
        String fileExtension = ".xml";
        String startFile = "AnXML.xml";
        File result = SwingHelper.chooseFile(title, startDirectory, fileExtension, startFile);
        assertNotNull("The file selected was null", result);
    }

    public void testChooseFile_String() {
        System.out.println("chooseFile");
        File result = SwingHelper.chooseFile("Choose a file");
        assertNotNull("The file selected was null", result);
    }

    public void testChooseFile_String_String() {
        System.out.println("chooseFile");
        String title = "Choose file";
        String fileExtension = ".txt";
        File result = SwingHelper.chooseFile(title, fileExtension);
        assertNotNull("The file selected was null", result);
    }

    public void testChooseFile_3args() {
        System.out.println("chooseFile");
        String title = "Choose a file";
        String fileExtension = ".xml";
        String startFile = "target/test-classes/com/diegohp/swing/";
        File result = SwingHelper.chooseFile(title, fileExtension, startFile);
        assertNotNull("The file selected was null", result);
    }
    
    public void testSetLookAndFeel() {
        System.out.println("Testing setLookAndFeel(SwingHelper.LookAndFeel)");
        
        SwingHelper.showErrorMessage("Error", "This is an error message using System Look and Feel.");
        SwingHelper.showWarningMessage("Warning", "This is a warning message using System Look and Feel");
        SwingHelper.showInformationMessage("Information", "This is an information message using System Look and Feel.");
        
        SwingHelper.setLookAndFeel(SwingHelper.LookAndFeel.MOTIF);
        SwingHelper.showErrorMessage("Error", "This is an error message using Motif Look and Feel.");
        SwingHelper.showWarningMessage("Warning", "This is a warning message using Motif Look and Feel");
        SwingHelper.showInformationMessage("Information", "This is an information message using Motif Look and Feel.");
        
        SwingHelper.setLookAndFeel(SwingHelper.LookAndFeel.NIMBUS);
        SwingHelper.showErrorMessage("Error", "This is an error message using Nimbus Look and Feel.");
        SwingHelper.showWarningMessage("Warning", "This is a warning messag eusing Nimbus Look and Feel");
        SwingHelper.showInformationMessage("Information", "This is an information message using Nimbus Look and Feel.");
        
        SwingHelper.setLookAndFeel(SwingHelper.LookAndFeel.METAL);
        SwingHelper.setMetalTheme(SwingHelper.MetalTheme.DEFAULT_METAL);
        SwingHelper.showErrorMessage("Error", "This is an error message using Metal Look and Feel with Default theme.");
        SwingHelper.showWarningMessage("Warning", "This is a warning message using Metal Look and Feel with Default theme.");
        SwingHelper.showInformationMessage("Information", "This is an information message using Metal Look and Feel with Default theme.");
        
        SwingHelper.setMetalTheme(SwingHelper.MetalTheme.OCEAN);
        SwingHelper.showErrorMessage("Error", "This is an error message using Metal Look and Feel with Ocean theme.");
        SwingHelper.showWarningMessage("Warning", "This is a warning message using Metal Look and Feel with Ocean theme.");
        SwingHelper.showInformationMessage("Information", "This is an information message using Metal Look and Feel with Ocean theme.");
        
        SwingHelper.setLookAndFeel(SwingHelper.LookAndFeel.SYSTEM);
    }
   
}