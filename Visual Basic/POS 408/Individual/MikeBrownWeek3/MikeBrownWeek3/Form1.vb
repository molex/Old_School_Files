Public Class Program2
    'Author Name:           Mike Brown
    'Date:                  November 15th, 2009
    'Release Notes:         This is version #1 of this program. The user will select an actor from a drop-down menu
    '                       and the text box will display all of the actor's work history as it pertains
    '                       to the James Bond Franchise. During the course of the design, I found some difficulty in lining up the text in the text box. Some lines of     '                       text reuired extra spaces in order to be properly aligned. Found a nice 007 Logo from http://www.thedctraveler.com and added it between the    '                       clear and exit buttons.
    'Program Requirements:  Create a GUI program that tracks some employees and their previous work history. List the employees names in a drop down combo box. When       '                       the user selects a employee, display 'in a text area all of their previous work performed under code name James Bond 007. In the text area     '                       cleanly output the following data in this order Left to Right (Sort top 'to bottom by the year oldest to new):  
    '                       Year 	Name of Mission	    Adjusted total box office
    '
    '                       1.Ensure that when another employee is selected from the combo box, the output is cleared from the text area and the new employee              '                          data is displayed. 
    '                       2.Create a clear button that clears all of the text in the text area and resets the combo box to its default setting.		
    '                       3.Create a ‘exit’ button. 									
    '                       4.Ensure to provide instruction to the user of how to use the program. Create a menu bar item which contains a ‘help’ function.	
    '

   

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'set the default focus on the combo box
        cmbName.SelectedItem = "Please Select an Employee:"
        cmbName.Focus()
    End Sub

    Private Sub cmbName_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles cmbName.SelectedIndexChanged
        'declare variable to be used to pass information to the displayResults Sub
        Dim empName As String

        'if user selects an employee, that employee is set as the employee name and passes to the displayResults Sub
        If cmbName.SelectedItem = "Sean Connery" Then
            empName = "Sean Connery"
            displayResults(empName)
        ElseIf cmbName.SelectedItem = "George Lazenby" Then
            empName = "George Lazenby"
            displayResults(empName)
        ElseIf cmbName.SelectedItem = "Roger Moore" Then
            empName = "Roger Moore"
            displayResults(empName)
        ElseIf cmbName.SelectedItem = "Timothy Dalton" Then
            empName = "Timothy Dalton"
            displayResults(empName)
        ElseIf cmbName.SelectedItem = "Pierce Brosnan" Then
            empName = "Pierce Brosnan"
            displayResults(empName)
        ElseIf cmbName.SelectedItem = "Daniel Craig" Then
            empName = "Daniel Craig"
            displayResults(empName)
        ElseIf cmbName.SelectedItem = "Please Select an Employee:" Then
            rtxtWorkHistory.Clear()
        End If

    End Sub

    Private Sub btnExit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnExit.Click
        'If the User selects the Exit button
        'the program will close
        Me.Close()
    End Sub

    Private Sub btnClear_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnClear.Click
        'When clicked, this button clears all the data from the text box and 
        'returns the combo box to "please select an employee
        Me.cmbName.SelectedIndex = -1
        Me.cmbName.SelectedItem = "Please Select an Employee:"
        Me.rtxtWorkHistory.Clear()

    End Sub

    Private Sub displayResults(ByVal empName As String)
        'Switch statement that allows the text box to display the correct history for each employee
        Select Case empName
            Case "Sean Connery"
                rtxtWorkHistory.Text = "Year" + vbTab + "Name Of Mission      " + vbTab + vbTab + "Adjusted Total Box Office" + vbNewLine + _
                                       "1962" + vbTab + "Dr. No                        " + vbTab + vbTab + "$425,488,741" + vbNewLine + _
                                       "1963" + vbTab + "From Russia with Love" + vbTab + vbTab + "$555,909,803" + vbNewLine + _
                                       "1964" + vbTab + "Goldfinger                    " + vbTab + vbTab + "$868,659,354" + vbNewLine + _
                                       "1965" + vbTab + "Thunderball                   " + vbTab + vbTab + "$966,435,555" + vbNewLine + _
                                       "1967" + vbTab + "You Only Live Twice  " + vbTab + vbTab + "$720,388,023" + vbNewLine + _
                                       "1971" + vbTab + "Diamonds Are Forever " + vbTab + vbTab + "$617,520,987"


            Case "George Lazenby"
                rtxtWorkHistory.Text = "Year" + vbTab + "Name Of Mission      " + vbTab + vbTab + "Adjusted Total Box Office" + vbNewLine + _
                                       "1969" + vbTab + "On Her Majesty's Secret Service" + vbTab + "$513,445,231"

            Case "Roger Moore"
                rtxtWorkHistory.Text = "Year" + vbTab + "Name Of Mission      " + vbTab + vbTab + "Adjusted Total Box Office" + vbNewLine + _
                                       "1973" + vbTab + "Live and Let Die         " + vbTab + vbTab + "$785,677,477" + vbNewLine + _
                                       "1974" + vbTab + "The Man with the Golden Gun" + vbTab + vbTab + "$426,826,774" + vbNewLine + _
                                       "1977" + vbTab + "The Spy Who Loved Me " + vbTab + vbTab + "$666,367,656" + vbNewLine + _
                                       "1979" + vbTab + "Moonraker                " + vbTab + vbTab + "$624,527,272" + vbNewLine + _
                                       "1981" + vbTab + "For Your Eyes Only  " + vbTab + vbTab + "$481,005,579" + vbNewLine + _
                                       "1983" + vbTab + "Octopussy                " + vbTab + vbTab + "$405,873,493" + vbNewLine + _
                                       "1985" + vbTab + "A View to a Kill         " + vbTab + vbTab + "$316,186,616"
            Case "Timothy Dalton"
                rtxtWorkHistory.Text = "Year" + vbTab + "Name Of Mission      " + vbTab + vbTab + "Adjusted Total Box Office" + vbNewLine + _
                                       "1987" + vbTab + "The Living Daylights" + vbTab + vbTab + "$362,876,056" + vbNewLine + _
                                       "1989" + vbTab + "From Russia with Love" + vbTab + vbTab + "$271,586,451"

            Case "Pierce Brosnan"
                rtxtWorkHistory.Text = "Year" + vbTab + "Name Of Mission      " + vbTab + vbTab + "Adjusted Total Box Office" + vbNewLine + _
                                       "1995" + vbTab + "GoldenEye                     " + vbTab + vbTab + "$499,954,330" + vbNewLine + _
                                       "1997" + vbTab + "Tomorrow Never Dies" + vbTab + vbTab + "$465,588,535" + vbNewLine + _
                                       "1999" + vbTab + "The World Is Not Enough" + vbTab + vbTab + "$504,705,882" + vbNewLine + _
                                       "2002" + vbTab + "Die Another Day      " + vbTab + vbTab + "$546,490,272"

            Case "Daniel Craig"
                rtxtWorkHistory.Text = "Year" + vbTab + "Name Of Mission      " + vbTab + vbTab + "Adjusted Total Box Office" + vbNewLine + _
                                       "2006" + vbTab + "Casino Royale          " + vbTab + vbTab + "$640,803,677" + vbNewLine + _
                                       "2008" + vbTab + "Quantum of Solace    " + vbTab + vbTab + "$586,090,727"

        End Select



    End Sub

    Private Sub AboutToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AboutToolStripMenuItem.Click
        'AboutBox.vb is written by Jeff Atwood and is freely available from the code project
        'http://www.codeproject.com/KB/vb/aboutbox.aspx
        '

        Dim frmAbout As New AboutBox
        frmAbout.ShowDialog(Me)
    End Sub

    Private Sub HowToToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles HowToToolStripMenuItem.Click
        'This code tells the program to open the Program #2 Help file and display it when the user clicks on the Help, then how to button on the menu
        Help.ShowHelp(Me, Application.StartupPath & "\How to use this program.chm")
    End Sub
End Class
