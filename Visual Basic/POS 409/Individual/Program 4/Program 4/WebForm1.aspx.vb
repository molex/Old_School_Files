Partial Public Class WebForm1
    Inherits System.Web.UI.Page

    'Author Name:           Mike Brown
    'Date:                  January 16th, 2010
    'Release Notes:         This is the form that will allow the user to enter thier data manually.
    '     

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        txtAmount.Attributes.Add("ontextchanged", "return NumericOnly()")
        txtRate.Attributes.Add("ontextchanged", "return NumericOnly()")
        txtTerm.Attributes.Add("ontextchanged", "return NumericOnly()")


    End Sub



    Protected Sub btnClear_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btnClear.Click
        txtAmount.Text = ""
        txtRate.Text = ""
        txtTerm.Text = ""
        rtxtDisplay.Text = ""

    End Sub

    Protected Sub btnCalculate_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btnCalculate.Click
        'clear any old data
        rtxtDisplay.Text = ""

        'create variables to get input from user
        Dim dblLoanAmount, dblRate, dblTerm As Double
        Dim strLoanAmount, strRate, strTerm As String

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


        If Me.txtRate.Text Is Nothing Then
            MsgBox("Rate Can not be Blank")
            txtRate.Focus()
        ElseIf Me.txtRate.Text = "" Then
            MsgBox("Rate Can not be Blank")
            txtRate.Text = ""
            txtRate.Focus()
        ElseIf Me.txtRate.Text = " " Then
            MsgBox("Rate Can not be Blank")
            txtRate.Text = ""
            txtRate.Focus()
        Else
            strRate = Me.txtRate.Text
        End If


        If Me.txtTerm.Text Is Nothing Then
            MsgBox("Term Can not be Blank")
            txtTerm.Focus()
        ElseIf Me.txtTerm.Text = "" Then
            MsgBox("Term Can not be Blank")
            txtTerm.Text = ""
            txtTerm.Focus()
        ElseIf Me.txtTerm.Text = " " Then
            MsgBox("Term Can not be Blank")
            txtTerm.Text = ""
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
            txtAmount.Text = ""
            txtAmount.Focus()
        End If
        If IsNumeric(strRate) Then
            dblRate = Convert.ToDouble(strRate)
        Else
            'this should never happen because I locked all keys except for the numeric ones :)
            MsgBox("Please enter a valid dollar amount")
            txtRate.Text = ""
            txtRate.Focus()
        End If
        If IsNumeric(strTerm) Then
            dblTerm = Convert.ToDouble(strTerm)
        Else
            'this should never happen because I locked all keys except for the numeric ones :)
            MsgBox("Please enter a valid dollar amount")
            txtTerm.Text = ""
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
            'display information in Chart


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


            'add info to chart
            Chart1.Series("Series1").Points.AddXY(intPaymentNumber, dblStartingbalance)

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