<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.btnReverse = New System.Windows.Forms.Button
        Me.txtOriginal = New System.Windows.Forms.TextBox
        Me.lblOriginalString = New System.Windows.Forms.Label
        Me.lblReverseString = New System.Windows.Forms.Label
        Me.txtReverse = New System.Windows.Forms.TextBox
        Me.SuspendLayout()
        '
        'btnReverse
        '
        Me.btnReverse.Location = New System.Drawing.Point(36, 181)
        Me.btnReverse.Name = "btnReverse"
        Me.btnReverse.Size = New System.Drawing.Size(75, 23)
        Me.btnReverse.TabIndex = 0
        Me.btnReverse.Text = "Reverse"
        Me.btnReverse.UseVisualStyleBackColor = True
        '
        'txtOriginal
        '
        Me.txtOriginal.Location = New System.Drawing.Point(69, 36)
        Me.txtOriginal.Name = "txtOriginal"
        Me.txtOriginal.Size = New System.Drawing.Size(100, 20)
        Me.txtOriginal.TabIndex = 1
        '
        'lblOriginalString
        '
        Me.lblOriginalString.AutoSize = True
        Me.lblOriginalString.Location = New System.Drawing.Point(13, 39)
        Me.lblOriginalString.Name = "lblOriginalString"
        Me.lblOriginalString.Size = New System.Drawing.Size(40, 13)
        Me.lblOriginalString.TabIndex = 2
        Me.lblOriginalString.Text = "String: "
        '
        'lblReverseString
        '
        Me.lblReverseString.AutoSize = True
        Me.lblReverseString.Location = New System.Drawing.Point(6, 71)
        Me.lblReverseString.Name = "lblReverseString"
        Me.lblReverseString.Size = New System.Drawing.Size(47, 13)
        Me.lblReverseString.TabIndex = 3
        Me.lblReverseString.Text = "Reverse"
        '
        'txtReverse
        '
        Me.txtReverse.Location = New System.Drawing.Point(69, 71)
        Me.txtReverse.Name = "txtReverse"
        Me.txtReverse.ReadOnly = True
        Me.txtReverse.Size = New System.Drawing.Size(100, 20)
        Me.txtReverse.TabIndex = 4
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.txtReverse)
        Me.Controls.Add(Me.lblReverseString)
        Me.Controls.Add(Me.lblOriginalString)
        Me.Controls.Add(Me.txtOriginal)
        Me.Controls.Add(Me.btnReverse)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents btnReverse As System.Windows.Forms.Button
    Friend WithEvents txtOriginal As System.Windows.Forms.TextBox
    Friend WithEvents lblOriginalString As System.Windows.Forms.Label
    Friend WithEvents lblReverseString As System.Windows.Forms.Label
    Friend WithEvents txtReverse As System.Windows.Forms.TextBox

End Class
