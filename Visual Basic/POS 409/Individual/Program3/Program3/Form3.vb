Imports Microsoft.VisualBasic.FileIO

Public Class Form3
    'Author Name:           Mike Brown
    'Date:                  January 2nd, 2010
    'Release Notes:         This is the form that allows the user to choose the mortgage from a drop down menu
    '                       that is taken from a file.
   

    'Module-level variable That will hold the input array from the file and the text field parser
    Dim strIterestArray() As String
    Private rateTextFieldParser As TextFieldParser

    Private Sub Form3_Load(ByVal sender As System.Object, _
                                 ByVal e As System.EventArgs) Handles MyBase.Load
        'Instatiate the TextFieldParser and set delimeters
        Dim FileString As String = "rateFile.txt"
        Try
            rateTextFieldParser = New TextFieldParser(FileString)
            rateTextFieldParser.TextFieldType = FieldType.Delimited
            rateTextFieldParser.SetDelimiters(",")
        Catch
            MessageBox.Show("Unable to read the file: " & FileString, "File Error")

        End Try
        'Read the file until EOF
        If Not rateTextFieldParser.EndOfData Then
            strIterestArray = rateTextFieldParser.ReadFields()
        End If
    End Sub

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

    Private Sub btnExit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnExit.Click
        'This closes the program
        Me.cmbLoanInfo.SelectedIndex = -1
        Me.txtAmount.Clear()
        Me.rtxtDisplay.Clear()
        Me.Hide()
    End Sub

    Private Sub btnClear_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnClear.Click
        'when the clear button is clicked restore all fields to blank and set focus to the txtAmount field
        Me.cmbLoanInfo.SelectedIndex = -1
        Me.txtAmount.Clear()
        Me.rtxtDisplay.Clear()
        Me.txtAmount.Focus()
        btnCalculate.Enabled = True
    End Sub

    Private Sub btnCalculate_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnCalculate.Click
        Dim dblLoanAmount As Double
        Dim strLoanAmount As String
        Dim dblLoanYear() As Double = {7, 15, 30}
        Dim dblTerm, dblRate As Double


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

        'check to ensure that the data entered is a number and then convert to double
        If IsNumeric(strLoanAmount) Then
            dblLoanAmount = Convert.ToDouble(strLoanAmount)
        Else
            'this should never happen because I locked all keys except for the numeric ones :)
            MsgBox("Please enter a valid dollar amount")
            txtAmount.Clear()
            txtAmount.Focus()
        End If

        'set the rate and term of the loan based on user choice
        If cmbLoanInfo.SelectedIndex = 1 Then
            dblTerm = dblLoanYear(0)
            dblRate = Convert.ToDouble(strIterestArray(0))
        ElseIf cmbLoanInfo.SelectedIndex = 2 Then
            dblTerm = dblLoanYear(1)
            dblRate = Convert.ToDouble(strIterestArray(1))
        ElseIf cmbLoanInfo.SelectedIndex = 3 Then
            dblTerm = dblLoanYear(2)
            dblRate = Convert.ToDouble(strIterestArray(2))
        ElseIf cmbLoanInfo.SelectedIndex = -1 Then
            MsgBox("Please Make a Selection")
            Me.cmbLoanInfo.Focus()
        Else
            'this should never happen
            MsgBox("Something has gone horribly wrong!")
        End If

        'calculate monthly payment
        If (dblLoanAmount > 0) Then
            calculateLoan(dblLoanAmount, dblTerm, dblRate)
            btnCalculate.Enabled = False
        Else
            MsgBox("Please Enter a Loan Amount Greater Than 0.00")
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

    Private Sub ExitToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ExitToolStripMenuItem.Click
        'This closes the program from the menu bar
        Me.cmbLoanInfo.SelectedIndex = -1
        Me.txtAmount.Clear()
        Me.rtxtDisplay.Clear()
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
        'This code tells the program to open the Program #2 Help file and display it when the user clicks on the Help, then how to button on the menu
        Help.ShowHelp(Me, Application.StartupPath & "\Program2.chm")
    End Sub


End Class
