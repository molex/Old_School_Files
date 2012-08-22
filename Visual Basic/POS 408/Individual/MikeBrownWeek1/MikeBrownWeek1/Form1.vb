'Program:     PayRateCalculator
'Author:      Mike Brown
'Date:        11/02/09
'Version:     1.0
'Purpose:     When a user enters the hours worked and pressed the Claculate button, the program will calculate the weekly pay for a select group of Employees
'
Public Class frmSalaryCalculator

    Private Sub Label1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles lblName1.Click

    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub

    Private Sub TextBox6_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtRate6.TextChanged

    End Sub

    Private Sub TextBox5_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtRate5.TextChanged

    End Sub

    Private Sub TextBox4_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtRate4.TextChanged

    End Sub

    Private Sub TextBox3_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtRate3.TextChanged

    End Sub

    Private Sub TextBox2_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtRate2.TextChanged

    End Sub

    Private Sub TextBox1_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtRate1.TextChanged

        
    End Sub

    Private Sub Label8_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles lblRateHeader.Click

    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnExit.Click
        'If the User selects the Exit button
        'the program will close
        Me.Close()
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnClear.Click
        'Clear all textboxes of thier data
        Me.txtHours1.Clear()
        Me.txtHours2.Clear()
        Me.txtHours2.Clear()
        Me.txtHours3.Clear()
        Me.txtHours4.Clear()
        Me.txtHours5.Clear()
        Me.txtHours6.Clear()
        Me.lblPay1.Text = ""
        Me.lblPay2.Text = ""
        Me.lblPay3.Text = ""
        Me.lblPay4.Text = ""
        Me.lblPay5.Text = ""
        Me.lblPay6.Text = ""


    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnCalculate.Click
        'Performs calculations and prints them to the appropriate Labels

        'Declare Variables
        Dim dblTotalPay1, dblTotalPay2, dblTotalPay3, dblTotalPay4, dblTotalPay5, dblTotalPay6 As Double
        Dim dblRate1, dblRate2, dblRate3, dblRate4, dblRate5, dblRate6 As Double
        Dim strNumberOfHours1, strNumberOfHours2, strNumberOfHours3, strNumberOfHours4, strNumberOfHours5, strNumberOfHours6 As String
        Dim dblNumberOfHours1, dblNumberOfHours2, dblNumberOfHours3, dblNumberOfHours4, dblNumberOfHours5, dblNumberOfHours6 As Double
       
        'Calculations for Sean Connery
        strNumberOfHours1 = Me.txtHours1.Text
        dblNumberOfHours1 = convertToDouble(strNumberOfHours1)

        dblRate1 = 75.0
        dblTotalPay1 = calculateTotalPay(dblNumberOfHours1, dblRate1)

        'This code changes the font to Green if the employee works overtime
        If dblNumberOfHours1 > 40 Then
            lblPay1.Text = dblTotalPay1.ToString("C")
            lblPay1.ForeColor = Color.Green

        ElseIf dblNumberOfHours1 <= 40 Then
            lblPay1.Text = dblTotalPay1.ToString("C")
            lblPay1.ForeColor = Color.Black
        End If

        'Calculations for George Lazenby
        strNumberOfHours2 = Me.txtHours2.Text
        dblNumberOfHours2 = convertToDouble(strNumberOfHours2)

        dblRate2 = 52.0
        dblTotalPay2 = calculateTotalPay(dblNumberOfHours2, dblRate2)

        'This code changes the font to Green if the employee works overtime
        If dblNumberOfHours2 > 40 Then
            lblPay2.Text = dblTotalPay2.ToString("C")
            lblPay2.ForeColor = Color.Green

        ElseIf dblNumberOfHours2 <= 40 Then
            lblPay2.Text = dblTotalPay2.ToString("C")
            lblPay2.ForeColor = Color.Black

        End If

        'Calculations for Roger Moore
        strNumberOfHours3 = Me.txtHours3.Text
        dblNumberOfHours3 = convertToDouble(strNumberOfHours3)

        dblRate3 = 80.0
        dblTotalPay3 = calculateTotalPay(dblNumberOfHours3, dblRate3)

        'This code changes the font to Green if the employee works overtime
        If dblNumberOfHours3 > 40 Then
            lblPay3.Text = dblTotalPay3.ToString("C")
            lblPay3.ForeColor = Color.Green

        ElseIf dblNumberOfHours3 <= 40 Then
            lblPay3.Text = dblTotalPay3.ToString("C")
            lblPay3.ForeColor = Color.Black

        End If

        'Calculations for Timothy Dalton
        strNumberOfHours4 = Me.txtHours4.Text
        dblNumberOfHours4 = convertToDouble(strNumberOfHours4)

        dblRate4 = 60.0
        dblTotalPay4 = calculateTotalPay(dblNumberOfHours4, dblRate4)

        'This code changes the font to Green if the employee works overtime
        If dblNumberOfHours4 > 40 Then
            lblPay4.Text = dblTotalPay4.ToString("C")
            lblPay4.ForeColor = Color.Green

        ElseIf dblNumberOfHours4 <= 40 Then
            lblPay4.Text = dblTotalPay4.ToString("C")
            lblPay4.ForeColor = Color.Black

        End If

        'Calculations for Pierce Brosnan
        strNumberOfHours5 = Me.txtHours5.Text
        dblNumberOfHours5 = convertToDouble(strNumberOfHours5)

        dblRate5 = 85.0
        dblTotalPay5 = calculateTotalPay(dblNumberOfHours5, dblRate5)

        'This code changes the font to Green if the employee works overtime
        If dblNumberOfHours5 > 40 Then
            lblPay5.Text = dblTotalPay5.ToString("C")
            lblPay5.ForeColor = Color.Green

        ElseIf dblNumberOfHours5 <= 40 Then
            lblPay5.Text = dblTotalPay5.ToString("C")
            lblPay5.ForeColor = Color.Black

        End If

        'Calculations for Daniel Craig
        strNumberOfHours6 = Me.txtHours6.Text
        dblNumberOfHours6 = convertToDouble(strNumberOfHours6)
        dblRate6 = 94.0
        dblTotalPay6 = calculateTotalPay(dblNumberOfHours6, dblRate6)

        'This code changes the font to Green if the employee works overtime
        If dblNumberOfHours6 > 40 Then
            lblPay6.Text = dblTotalPay6.ToString("C")
            lblPay6.ForeColor = Color.Green

        ElseIf dblNumberOfHours6 <= 40 Then
            lblPay6.Text = dblTotalPay6.ToString("C")
            lblPay6.ForeColor = Color.Black

        End If


    End Sub

    Private Sub Label11_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles lblPay1.Click

    End Sub

    Private Sub TextBox12_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtHours1.TextChanged
        'Set Focus to this Textbox
        Me.txtHours1.Focus()

        'If the user enters data in this text box enable the Clear and Calculate button
        If Me.txtHours1 IsNot Nothing Then
            btnClear.Enabled = True
            btnCalculate.Enabled = True
        End If

    End Sub

    Private Sub txtHours2_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtHours2.TextChanged
        'If the user enters data in this text box enable the Clear and Calculate button

        If Me.txtHours2 IsNot Nothing Then
            btnClear.Enabled = True
            btnCalculate.Enabled = True
        End If
    End Sub

    Private Sub txtHours3_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtHours3.TextChanged
        'If the user enters data in this text box enable the Clear and Calculate button

        If Me.txtHours3 IsNot Nothing Then
            btnClear.Enabled = True
            btnCalculate.Enabled = True
        End If
    End Sub

    Private Sub txtHours4_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtHours4.TextChanged
        'If the user enters data in this text box enable the Clear and Calculate button

        If Me.txtHours4 IsNot Nothing Then
            btnClear.Enabled = True
            btnCalculate.Enabled = True
        End If
    End Sub

    Private Sub txtHours5_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtHours5.TextChanged
        'If the user enters data in this text box enable the Clear and Calculate button

        If Me.txtHours5 IsNot Nothing Then
            btnClear.Enabled = True
            btnCalculate.Enabled = True
        End If
    End Sub

    Private Sub txtHours6_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtHours6.TextChanged
        'If the user enters data in this text box enable the Clear and Calculate button

        If Me.txtHours6 IsNot Nothing Then
            btnClear.Enabled = True
            btnCalculate.Enabled = True
        End If
    End Sub

    Function convertToDouble(ByVal strNumberOfHours As String)
        'This function takes the String that was entered by the user and converts it to a type double
        'which is usable for doing calculations
        '
        Dim dblNumberOfHours As Double

        If IsNumeric(strNumberOfHours) Then
            dblNumberOfHours = Convert.ToDouble(strNumberOfHours)
        Else
            MsgBox("Input must be in the form of a number. Try, something like: 40 ")
        End If

        Return dblNumberOfHours
    End Function

    Function calculateTotalPay(ByVal dblNumberOfHours As Double, ByVal dblRate As Double)
        'This function takes the number of hours and multiplies it by the pay rate 
        'if the employee worked over 40 hours, then overtime is calculated as well

        Dim dblAmountOvertime, dblOvertimeRate, dblRegularPay, dblOvertimePay, dblTotalPay As Double


        'This happens if there is overtime
        If dblNumberOfHours > 40 Then
            dblAmountOvertime = (dblNumberOfHours - 40)
            dblOvertimeRate = (dblRate * 1.5)
            dblRegularPay = (40 * dblRate)
            dblOvertimePay = (dblOvertimeRate * dblAmountOvertime)
            dblTotalPay = (dblRegularPay + dblOvertimePay)

            'This is the code if there is no overtime
        ElseIf dblNumberOfHours <= 40 Then
            dblTotalPay = dblRate * dblNumberOfHours
        End If

        Return dblTotalPay

    End Function

    Private Sub AboutThisProgramToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AboutThisProgramToolStripMenuItem.Click
        'AboutBox.vb is written by Jeff Atwood and is freely available from the code project
        'http://www.codeproject.com/KB/vb/aboutbox.aspx
        '

        Dim frmAbout As New AboutBox
        frmAbout.ShowDialog(Me)
    End Sub

    Private Sub HowTOToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles HowTOToolStripMenuItem.Click


    End Sub

    Private Sub HowToUseThisProgramToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles HowToUseThisProgramToolStripMenuItem.Click
        'This code tells the program to open the Salary Calculator Help file and display it when the user clicks on the Help, then how to button on the menu
        Help.ShowHelp(Me, Application.StartupPath & "\Salary Calculator.chm")

    End Sub
End Class
