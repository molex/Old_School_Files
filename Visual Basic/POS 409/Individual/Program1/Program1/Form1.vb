Public Class Form1
    'Author Name:           Mike Brown
    'Date:                  December 2nd, 2009
    'Release Notes:         This is version #1.0 of this program. This is the first fully functional version of the prgram. I have added full button functionality, 
    '                       error checking on the user input, and help files.
    '
    'Program Requirements:  Write the program in VB.Net (not Web based) with a graphical user interface. Have the user input
    '                       the amount of the mortgage, the term of the mortgage and the interest rate. Display the mortgage
    '                       payment amount based on the user’s inputs. Allow the user to loop back and enter new data or quit.
    '                       Insert comments to document the program.
    '

    Private Sub btnExit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnExit.Click
        'This closes the program with a button
        Me.Close()
    End Sub

    Private Sub ExitToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ExitToolStripMenuItem.Click
        'This closes the program from the menu bar
        Me.Close()
    End Sub

    Private Sub AboutToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AboutToolStripMenuItem.Click
        'AboutBox.vb is written by Jeff Atwood and is freely available from the code project
        'http://www.codeproject.com/KB/vb/aboutbox.aspx
        '

        Dim frmAbout As New AboutBox
        frmAbout.ShowDialog(Me)
    End Sub

    Private Sub HowToToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles HowToToolStripMenuItem.Click
        'This code tells the program to open the Program #3 Help file and display it when the user clicks on the Help, then how to button on the menu
        Help.ShowHelp(Me, Application.StartupPath & "\Program1.chm")
    End Sub


    Private Sub btnClear_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnClear.Click
        'clear all text boxes and clear the rich text box
        txtAmount.Clear()
        txtRate.Clear()
        txtTerm.Clear()
        rtxtDisplay.Clear()

    End Sub

    Private Sub btnCalculate_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnCalculate.Click
        'clear any old data
        rtxtDisplay.Clear()

        'create variables to get input from user
        Dim dblLoanAmount, dblRate, dblTerm, dblMonthlyPayment As Double
        Dim strLoanAmount, strRate, strTerm As String

        'store user data into variables and ensure they are not left blank
        strLoanAmount = Me.txtAmount.Text
        If Me.txtAmount.Text Is Nothing Then
            MsgBox("Loan Amount Can not be Blank")
            txtAmount.Focus()
        ElseIf Me.txtAmount.Text = "" Then
            MsgBox("Loan Amount Can not be Blank")
            txtAmount.Clear()
            txtAmount.Focus()
        ElseIf strLoanAmount = " " Then
            MsgBox("Loan Amount Can not be Blank")
            txtAmount.Clear()
            txtAmount.Focus()
        Else
            strLoanAmount = Me.txtAmount.Text
        End If


        If Me.txtRate.Text Is Nothing Then
            MsgBox("Rate Can not be Blank")
            txtRate.Focus()
        ElseIf Me.txtRate.Text = "" Then
            MsgBox("Rate Can not be Blank")
            txtRate.Clear()
            txtRate.Focus()
        ElseIf Me.txtRate.Text = " " Then
            MsgBox("Rate Can not be Blank")
            txtRate.Clear()
            txtRate.Focus()
        Else
            strRate = Me.txtRate.Text
        End If


        If Me.txtTerm.Text Is Nothing Then
            MsgBox("Term Can not be Blank")
            txtTerm.Focus()
        ElseIf Me.txtTerm.Text = "" Then
            MsgBox("Term Can not be Blank")
            txtTerm.Clear()
            txtTerm.Focus()
        ElseIf Me.txtTerm.Text = " " Then
            MsgBox("Term Can not be Blank")
            txtTerm.Clear()
            txtTerm.Focus()
        Else
            strTerm = Me.txtTerm.Text
        End If


        'check to ensure that the data entered is a number and then convert to double
        If IsNumeric(strLoanAmount) Then
            dblLoanAmount = Convert.ToDouble(strLoanAmount)
        Else
            'this should never happen because I locked all keys except for the numeric ones :)
            MsgBox("Please enter a valid dollar amount")
            txtAmount.Clear()
            txtAmount.Focus()
        End If
        If IsNumeric(strRate) Then
            dblRate = Convert.ToDouble(strRate)
        Else
            'this should never happen because I locked all keys except for the numeric ones :)
            MsgBox("Please enter a valid dollar amount")
            txtRate.Clear()
            txtRate.Focus()
        End If
        If IsNumeric(strTerm) Then
            dblTerm = Convert.ToDouble(strTerm)
        Else
            'this should never happen because I locked all keys except for the numeric ones :)
            MsgBox("Please enter a valid dollar amount")
            txtTerm.Clear()
            txtTerm.Focus()
        End If
        'calculate monthly paymet
        dblMonthlyPayment = calculateLoan(dblLoanAmount, dblTerm, dblRate)

        'display payment information in rich text box
        rtxtDisplay.Text = "The Loan Amount is: " + dblLoanAmount.ToString("C") + vbNewLine + _
        "The Term is: " + dblTerm.ToString() + vbNewLine + _
        "The Interest Rate is: " + dblRate.ToString() + vbNewLine + _
        "Your Monthly Payment Will Be: " + dblMonthlyPayment.ToString("C")

        MsgBox("To Continue, Hit The Clear Button")

    End Sub
    Function calculateLoan(ByRef dblLoanAmount As Double, ByRef dblTerm As Double, ByRef dblRate As Double)
        'create varibles
        Dim dblMonthlyPayment, dblTermInMonths, dblMonthlyRate As Double

        'convert term to months
        dblTermInMonths = (dblTerm * 12)
        'convert interest rate to monthly interest
        dblMonthlyRate = (dblRate / (12 * 100))
        ' create monthly payment by using the formula: M = P * ( J / (1 - (1 + J) ** -N))
        ' where M is the monthlyPayment, P is the LoanAmount, J is the MonthlyRate,
        ' and N is the TermInMonths. The formula should then result in
        ' returning the total monthly payment. 
        dblMonthlyPayment = dblLoanAmount * (dblMonthlyRate / (1 - Math.Pow((1 + dblMonthlyRate), (-dblTermInMonths))))

        Return dblMonthlyPayment

    End Function

    Private Sub txtAmount_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles txtAmount.KeyPress
        'This controls the Loan Amount Text Box. If the user enters any key that is not a number, they will get a messsage that tells them they can only enter numbers
        If (Microsoft.VisualBasic.Asc(e.KeyChar) < 48) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) > 57) Then
            e.Handled = True
            MsgBox("You can only enter numbers here!")
            txtAmount.Focus()
        End If
        If (Microsoft.VisualBasic.Asc(e.KeyChar) = 8) Then
            e.Handled = False
        End If
    End Sub
    Private Sub txtRate_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles txtRate.KeyPress
        'This controls the Loan Rate Text Box. If the user enters any key that is not a number, they will get a messsage that tells them they can only enter numbers
        If (Microsoft.VisualBasic.Asc(e.KeyChar) < 48) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) > 57) Then
            e.Handled = True
            MsgBox("You can only enter numbers here!")
            txtRate.Focus()
        End If
        If (Microsoft.VisualBasic.Asc(e.KeyChar) = 8) Then
            e.Handled = False
        End If
    End Sub
    Private Sub txtTerm_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles txtTerm.KeyPress
        'This controls the LoanTerm Text Box. If the user enters any key that is not a number, they will get a messsage that tells them they can only enter numbers
        If (Microsoft.VisualBasic.Asc(e.KeyChar) < 48) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) > 57) Then
            e.Handled = True
            MsgBox("You can only enter numbers here!")
            txtTerm.Focus()
        End If
        If (Microsoft.VisualBasic.Asc(e.KeyChar) = 8) Then
            e.Handled = False
        End If
    End Sub

End Class
