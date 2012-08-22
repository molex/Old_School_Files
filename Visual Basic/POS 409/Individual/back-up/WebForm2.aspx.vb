Imports Microsoft.VisualBasic.FileIO
Partial Public Class WebForm2
    Inherits System.Web.UI.Page
    
    'Author Name:           Mike Brown
    'Date:                  January 16th, 2010
    'Release Notes:         This is the form that allows the user to choose the mortgage from a drop down menu
    '                       that is taken from a file.

    'Module-level variable That will hold the input array from the file and the text field parser
    Dim strIterestArray() As String
    Private rateTextFieldParser As TextFieldParser

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        'Instatiate the TextFieldParser and set delimeters
        Dim FileString As String = Server.MapPath("rateFile.txt")
        Try
            rateTextFieldParser = New TextFieldParser(FileString)
            rateTextFieldParser.TextFieldType = FieldType.Delimited
            rateTextFieldParser.SetDelimiters(",")
        Catch
            MsgBox("Unable to read the file, File Error")

        End Try
        'Read the file until EOF
        If Not rateTextFieldParser.EndOfData Then
            strIterestArray = rateTextFieldParser.ReadFields()
        End If

    End Sub
   
    

    Protected Sub btnClear_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btnClear.Click
        txtAmount.Text = ""
        cmbLoanInfo.SelectedIndex = -1
        rtxtDisplay.Text = ""
    End Sub

    Protected Sub btnCalculate_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btnCalculate.Click
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
            txtAmount.Text = ""
            txtAmount.Focus()
        ElseIf strLoanAmount = " " Then
            MsgBox("Loan Amount Can not be Blank")
            txtAmount.Text = ""
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
            txtAmount.Text = ""
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
End Class