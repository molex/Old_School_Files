'Author Name:           Mike Brown
'Date:                  January 2nd, 2010
'Description:           Write the program in VB.Net (not Web based) with a graphical user interface. Allow the user to
'                       Select which way they want to calculate the mortgage: By input of the amount of the mortgage, the
'                       term of the mortgage and the interest rate of the mortgage
'                       or
'                       By input of the amount of the mortgage and then select from a menu of mortgage loans:
'                       - 7 years at 5.35%
'                       - 15 years at 5.5%
'                       - 30 years at 5.75%
'                       In either case, display the mortgage payment amount. Then, list the loan balance and interest paid
'                       for each payment over the term of the loan. Allow the user to loop back and enter a new amount
'                       and make a new selection, or quit. Load the interest rates for the 7 year, 15 year, and 30 year loans
'                       from a file. Insert comments to document the program.
'Release Notes:         This is version # 3.0 of this program. I added a main screen. Combined versions 1 + 2  with this version. 
'                       Added Amortization to the manual entry. I also changed the rates to be read from a file called rateFile.txt. 
'



Public Class Form1

    Private Sub Label1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Label1.Click

    End Sub

    Private Sub HOwToToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles HOwToToolStripMenuItem.Click
        'This code tells the program to open the Program #3 Help file and display it when the user clicks on the Help, then how to button on the menu
        Help.ShowHelp(Me, Application.StartupPath & "\Program 3.chm")
    End Sub

    Private Sub ExitToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ExitToolStripMenuItem.Click
        Me.Close()
    End Sub

    Private Sub AboutToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AboutToolStripMenuItem.Click
        'AboutBox.vb is written by Jeff Atwood and is freely available from the code project
        'http://www.codeproject.com/KB/vb/aboutbox.aspx
        '

        Dim frmAbout As New AboutBox
        frmAbout.ShowDialog(Me)
    End Sub

    Private Sub btnManual_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnManual.Click
        Form2.ShowDialog()
    End Sub

    Private Sub btnMenu_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnMenu.Click
        Form3.ShowDialog()
    End Sub

    Private Sub btnExit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnExit.Click
        Me.Close()
    End Sub
End Class
