Public Class Form2
    'Author Name:           Mike Brown
    'Date:                  January 2nd, 2010
    'Release Notes:         This is the form that will allow the user to enter thier data manually.
    '     

    Private Sub btnExit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnExit.Click
        'This closes the program with a button
        txtAmount.Clear()
        txtRate.Clear()
        txtTerm.Clear()
        rtxtDisplay.Clear()
        Me.Hide()
    End Sub

    Private Sub ExitToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ExitToolStripMenuItem.Click
        'This closes the program from the menu bar
        txtAmount.Clear()
        txtRate.Clear()
        txtTerm.Clear()
        rtxtDisplay.Clear()
        Me.Hide()
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
        Me.txtAmount.Focus()
       

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
        If dblLoanAmount <= 0 Then
            MsgBox("Loan Amount must be greater than 0")
        ElseIf dblRate < 0 Then
            MsgBox("Rate Must be a value greater than 0")
        ElseIf dblTerm <= 0 Then
            MsgBox("Term must be greater than 0")
        Else
            'calculate monthly paymet
            calculateLoan(dblLoanAmount, dblTerm, dblRate)
            'display payment information in rich text box

            MsgBox("To Continue, Hit The Clear Button")

        End If
        
    End Sub
    Sub calculateLoan(ByRef dblLoanAmount As Double, ByRef dblTerm As Double, ByRef dblRate As Double)
        'create varibles
        Dim dblMonthlyPayment, dblTermInMonths, dblMonthlyRate, dblMonthlyInterestAmount, dblPrincipal, dblStartingbalance, dblCurrentBalance As Double
        Dim intPaymentNumber As Integer = 1
        'convert term to months
        dblTermInMonths = (dblTerm * 12)
        'convert interest rate to monthly interest rate
        dblMonthlyRate = (dblRate / (12 * 100))
        'set initial starting balance = to user entered loan amount
        dblStartingbalance = dblLoanAmount
        'set intial currentBalacne = to the startingBalance
        dblCurrentBalance = dblStartingbalance
        While (intPaymentNumber <= dblTermInMonths)
            dblMonthlyPayment = payEachMonth(dblLoanAmount, dblMonthlyRate, dblTermInMonths)
            dblMonthlyInterestAmount = getMonthlyInterest(dblCurrentBalance, dblMonthlyRate)
            dblPrincipal = getPrincipalPaid(dblMonthlyPayment, dblMonthlyInterestAmount)
            dblCurrentBalance = getCurrentBalance(dblPrincipal, dblStartingbalance)

            'display payment information in rich text box
            rtxtDisplay.Text += "Payment Number: " + intPaymentNumber.ToString() + vbNewLine + _
            "The Loan Payment is: " + dblMonthlyPayment.ToString("C") + vbNewLine + _
            "The Loan Balance is: " + dblCurrentBalance.ToString("C") + vbNewLine + _
            "The Interest Paid is: " + dblMonthlyInterestAmount.ToString("C") + vbNewLine + _
            "___________________________________________" + vbNewLine

            'increase payment number 
            intPaymentNumber += 1
            'set new starting balance = to the current balance
            dblStartingbalance = dblCurrentBalance

        End While

    End Sub
    Function getMonthlyInterest(ByVal dblCurrentBalance, ByVal dblMonthlyInterestRate)
        'generate the amount of $ that goes to interest per month
        Dim dblMonthlyInterest = (dblCurrentBalance * dblMonthlyInterestRate)
        Return dblMonthlyInterest
    End Function
    Function getPrincipalPaid(ByVal dblMonthlyPayment, ByVal dblMonthlyInterestAmount)
        'genereate the amount of $ that goes to the principal each month
        Dim dblPrincipalPayment = (dblMonthlyPayment - dblMonthlyInterestAmount)
        Return dblPrincipalPayment
    End Function
    Function getCurrentBalance(ByVal dblPrincipal, ByVal dblStartingBalance)
        'generate the new current balance
        Dim dblCurrentBalance = (dblStartingBalance - dblPrincipal)
        Return dblCurrentBalance
    End Function
    Function payEachMonth(ByVal dblLoanAmount, ByVal dblMonthlyRate, ByVal dblTermInMonths)
        ' create monthly payment by using the formula: M = P * ( J / (1 - (1 + J) ** -N))
        ' where M is the monthlyPayment, P is the LoanAmount, J is the MonthlyRate,
        ' and N is the TermInMonths. The formula should then result in
        ' returning the total monthly payment. 
        Dim dblPayPerMonth = dblLoanAmount * (dblMonthlyRate / (1 - Math.Pow((1 + dblMonthlyRate), (-dblTermInMonths))))
        Return dblPayPerMonth
    End Function

    Private Sub txtAmount_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles txtAmount.KeyPress
        'This controls the Loan Amount Text Box. If the user enters any key that is not a number, they will get a messsage that tells them they can only enter numbers
        If (Microsoft.VisualBasic.Asc(e.KeyChar) < 48) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) > 57) Then
            e.Handled = True
            If (Microsoft.VisualBasic.Asc(e.KeyChar) = 8) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) = 46) Then
                e.Handled = False
            End If
        End If
        If (e.Handled = True) Then
            MsgBox("You can only enter numbers here!")
            txtAmount.Focus()
        End If
    End Sub
    Private Sub txtRate_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles txtRate.KeyPress
        'This controls the Loan Rate Text Box. If the user enters any key that is not a number, they will get a messsage that tells them they can only enter numbers
        If (Microsoft.VisualBasic.Asc(e.KeyChar) < 48) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) > 57) Then
            e.Handled = True
            If (Microsoft.VisualBasic.Asc(e.KeyChar) = 8) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) = 46) Then
                e.Handled = False
            End If
        End If
        If (e.Handled = True) Then
            MsgBox("You can only enter numbers here!")
            txtAmount.Focus()
        End If
    End Sub
    Private Sub txtTerm_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles txtTerm.KeyPress
        'This controls the LoanTerm Text Box. If the user enters any key that is not a number, they will get a messsage that tells them they can only enter numbers
        If (Microsoft.VisualBasic.Asc(e.KeyChar) < 48) _
                   Or (Microsoft.VisualBasic.Asc(e.KeyChar) > 57) Then
            e.Handled = True
            If (Microsoft.VisualBasic.Asc(e.KeyChar) = 8) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) = 46) Then
                e.Handled = False
            End If
        End If
        If (e.Handled = True) Then
            MsgBox("You can only enter numbers here!")
            txtAmount.Focus()
        End If
    End Sub
End Class