Public Class Program3
    'Author Name:           Mike Brown
    'Date:                  November 16th, 2009
    'Release Notes:         This is version #1 of this program. The user will try and guess at a randomly generated number
    '                       The program will let the user onw if they were over or under the number. They will continue to guess until correct.
    '                       I am unhappy that I had to use a global variable "answer" in order to use the randomly generated number in multiple places.I tried to find a 
    '                       good way to resolve this, but using a seperate class and properties prooved to be too cumbersome. For a program like this, where there is no 
    '                       other way to change the variable, it didn't make much sense to go through all the trouble of getters and setters, for one random number.
    '
    'Program Requirements:  Your GUI program is a game to be played by the user. A new employee is working on a classified mission and 
    '                       the program will randomly 'pick an expected profit to be guessed by the user. The program must randomly select an integer within the range of
    '                       1 to 900. The figures are depicted short hand for 'millions, meaning 1 is 1million and 900 is 900 million.									
    '									
    'Other requirements: 	1. Create a form that displays the following text in a label, “What do you think the current mission will profit? 
    '                          "Please guess a number between 1 and 900.”								
    '                       2. Create a textbox for the user to input the guess. 									
    '                       3. If the user is outside the given range, provide a proper message. And allow the user to continue to play.									
    '                       4. When a user has a valid guess, display on a label either “too high” or “too low,” to help the user guess the correct number.  
    '                          Tell the user to click Reset							
    '                       5. When the user guesses the correct number, display “correct!” in a message box, change the form’s background color to red and 
    '                          disable the textbox. 									
    '                       6. Create a ‘reset’ button that allows the user to play the game again with a new random number. 									
    '                       7. Create a ‘show me’ button that displays the number on a message box yet allows the game to continue.								
    '                       8. Create a ‘exit’ button to exit the program.									
    '                       9. Ensure that you include error checking to prevent a user guess that is out of the given range and for any non-numeric characters.				'					
    '                       10. Ensure to provide instruction to the user of how to use the program. Create a menu bar item which contains a ‘help’ function.	
    '

    Dim answer As Integer

    Private Sub btnExit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnExit.Click
        'If the User selects the Exit button
        'the program will close
        Me.Close()
    End Sub

    Private Sub AboutToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AboutToolStripMenuItem.Click
        'AboutBox.vb is written by Jeff Atwood and is freely available from the code project
        'http://www.codeproject.com/KB/vb/aboutbox.aspx
        '

        Dim frmAbout As New AboutBox
        frmAbout.ShowDialog(Me)
    End Sub

    Private Sub Program3_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'When the program is loaded this will generate a random number and assign it to the variable answer
        Dim initialRandom = randomNumbers()
        answer = initialRandom
    End Sub

    Private Sub btnReset_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnReset.Click
        'This clears the text box of previous guesses
        txtGuess.Clear()
        'This clears the label of all information
        lblResults.Text = ""
        'sets the focus back on the text box
        txtGuess.Focus()
        'generates a new random number and assigns it to answer
        Dim newRandom = randomNumbers()
        answer = newRandom
        'returns the backgorund color to white and re-enables the text box & Guess button if the last game ended in victory
        BackColor = Color.White
        txtGuess.Enabled = True
        btnGuess.Enabled = True
    End Sub
    Function randomNumbers()
        'This Function takes no parameters and returns a new random number
        'Create a new Random class in VB.NET
        Dim RandomClass As New Random()
        Dim RandomNumber As Integer
        RandomNumber = RandomClass.Next(1, 900)
        Return RandomNumber
    End Function

    Private Sub btnShowMe_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnShowMe.Click
        'creates a pop up box that tells the user the answer
        MsgBox("The answer is: " & answer)
    End Sub

    Private Sub btnGuess_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnGuess.Click
        'takes the data from the text box and passes it to the convertToInteger function, then assigns that value to intGuess
        Dim strGuess As String
        Dim intGuess As Integer
        strGuess = Me.txtGuess.Text
        intGuess = convertToInteger(strGuess)
        'takes the intGuess value and passes it to the checkIfCorrect function to test how the user guessed
        checkIfCorrect(intGuess)

    End Sub
    Function convertToInteger(ByVal strGuess As String)
        'This function takes the String that was entered by the user and converts it to a type Integer
        '
        '
        Dim intGuess As Integer

        'Checks to see if the string is actually an integer, then converts it to an integer
        If IsNumeric(strGuess) Then
            intGuess = Convert.ToInt32(strGuess)
            If (intGuess < 0) Then
                'if the integer is less than 0, user is prompted to enter a number between 0 and 900
                MsgBox("You must enter a positive number! Try 0-900")
                txtGuess.Clear()
                txtGuess.Focus()
            ElseIf (intGuess > 900) Then
                'if the number is greater than 900 user is prompted to re-enter a valid value
                MsgBox("You must enter a number between 0 and 900")
                txtGuess.Clear()
                txtGuess.Focus()
            End If
        Else
            'If the string is not an integer the user will be promted to try again
            MsgBox("Input must be in the form of a number between 1 and 900!")
            txtGuess.Clear()
            txtGuess.Focus()
        End If

        Return intGuess
    End Function
    Sub checkIfCorrect(ByVal intGuess As Integer)
        'This Sub checks the value of the user's guess and compares it to the actual answer

        'if the user's guess is too high
        If intGuess > answer Then
            lblResults.Text = "Too high"
            txtGuess.Clear()
            txtGuess.Focus()
        ElseIf intGuess < answer Then
            'user guess is too low
            lblResults.Text = "Too low"
            txtGuess.Clear()
            txtGuess.Focus()
        ElseIf intGuess = answer Then
            'user guess is correct, then background turns red and textbox is disabled
            BackColor = Color.Red
            lblResults.Text = "Correct!!!!!"
            txtGuess.Enabled = False
            btnGuess.Enabled = False

        Else
            'This message should never appear. The user's guess can only be less than, greater than, or equal to the answer
            MsgBox("This should not have happened! Please remain calm.")
        End If

    End Sub

    Private Sub HowToToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles HowToToolStripMenuItem.Click
        'This code tells the program to open the Program #3 Help file and display it when the user clicks on the Help, then how to button on the menu
        Help.ShowHelp(Me, Application.StartupPath & "\week4.chm")
    End Sub

    Private Sub PictureBox1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles PictureBox1.Click

    End Sub
End Class
