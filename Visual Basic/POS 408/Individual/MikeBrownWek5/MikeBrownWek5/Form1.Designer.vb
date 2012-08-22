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
        Me.txtTitle = New System.Windows.Forms.TextBox
        Me.txtBoxOffice = New System.Windows.Forms.TextBox
        Me.lblTitle = New System.Windows.Forms.Label
        Me.lblBoxOffice = New System.Windows.Forms.Label
        Me.btnAdd = New System.Windows.Forms.Button
        Me.btntTitle = New System.Windows.Forms.Button
        Me.btnBoxOffice = New System.Windows.Forms.Button
        Me.btnEasy = New System.Windows.Forms.Button
        Me.rtxtDisplay = New System.Windows.Forms.RichTextBox
        Me.lblGross = New System.Windows.Forms.Label
        Me.MenuStrip1 = New System.Windows.Forms.MenuStrip
        Me.HelpToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem
        Me.AboutToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem
        Me.HowToToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem
        Me.btnClear = New System.Windows.Forms.Button
        Me.lblGrossTitles = New System.Windows.Forms.Label
        Me.btnExit = New System.Windows.Forms.Button
        Me.MenuStrip1.SuspendLayout()
        Me.SuspendLayout()
        '
        'txtTitle
        '
        Me.txtTitle.Location = New System.Drawing.Point(70, 51)
        Me.txtTitle.Name = "txtTitle"
        Me.txtTitle.Size = New System.Drawing.Size(198, 20)
        Me.txtTitle.TabIndex = 0
        '
        'txtBoxOffice
        '
        Me.txtBoxOffice.Location = New System.Drawing.Point(421, 51)
        Me.txtBoxOffice.Name = "txtBoxOffice"
        Me.txtBoxOffice.Size = New System.Drawing.Size(133, 20)
        Me.txtBoxOffice.TabIndex = 1
        '
        'lblTitle
        '
        Me.lblTitle.AutoSize = True
        Me.lblTitle.Location = New System.Drawing.Point(13, 54)
        Me.lblTitle.Name = "lblTitle"
        Me.lblTitle.Size = New System.Drawing.Size(30, 13)
        Me.lblTitle.TabIndex = 2
        Me.lblTitle.Text = "Title:"
        '
        'lblBoxOffice
        '
        Me.lblBoxOffice.AutoSize = True
        Me.lblBoxOffice.Location = New System.Drawing.Point(288, 54)
        Me.lblBoxOffice.Name = "lblBoxOffice"
        Me.lblBoxOffice.Size = New System.Drawing.Size(127, 13)
        Me.lblBoxOffice.TabIndex = 3
        Me.lblBoxOffice.Text = "Adjusted Total Box Office"
        '
        'btnAdd
        '
        Me.btnAdd.Location = New System.Drawing.Point(12, 417)
        Me.btnAdd.Name = "btnAdd"
        Me.btnAdd.Size = New System.Drawing.Size(75, 23)
        Me.btnAdd.TabIndex = 4
        Me.btnAdd.Text = "Add"
        Me.btnAdd.UseVisualStyleBackColor = True
        '
        'btntTitle
        '
        Me.btntTitle.Location = New System.Drawing.Point(93, 417)
        Me.btntTitle.Name = "btntTitle"
        Me.btntTitle.Size = New System.Drawing.Size(106, 23)
        Me.btntTitle.TabIndex = 5
        Me.btntTitle.Text = "Sort By Title"
        Me.btntTitle.UseVisualStyleBackColor = True
        '
        'btnBoxOffice
        '
        Me.btnBoxOffice.Location = New System.Drawing.Point(205, 417)
        Me.btnBoxOffice.Name = "btnBoxOffice"
        Me.btnBoxOffice.Size = New System.Drawing.Size(106, 23)
        Me.btnBoxOffice.TabIndex = 6
        Me.btnBoxOffice.Text = "Sort By Box Office"
        Me.btnBoxOffice.UseVisualStyleBackColor = True
        '
        'btnEasy
        '
        Me.btnEasy.BackColor = System.Drawing.Color.Red
        Me.btnEasy.Location = New System.Drawing.Point(398, 417)
        Me.btnEasy.Name = "btnEasy"
        Me.btnEasy.Size = New System.Drawing.Size(75, 23)
        Me.btnEasy.TabIndex = 7
        Me.btnEasy.Text = "Easy Button"
        Me.btnEasy.UseVisualStyleBackColor = False
        '
        'rtxtDisplay
        '
        Me.rtxtDisplay.Font = New System.Drawing.Font("Courier New", 8.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.rtxtDisplay.Location = New System.Drawing.Point(12, 99)
        Me.rtxtDisplay.Name = "rtxtDisplay"
        Me.rtxtDisplay.Size = New System.Drawing.Size(542, 290)
        Me.rtxtDisplay.TabIndex = 8
        Me.rtxtDisplay.Text = ""
        '
        'lblGross
        '
        Me.lblGross.AutoSize = True
        Me.lblGross.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Underline), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblGross.Location = New System.Drawing.Point(566, 99)
        Me.lblGross.Name = "lblGross"
        Me.lblGross.Size = New System.Drawing.Size(117, 13)
        Me.lblGross.TabIndex = 9
        Me.lblGross.Text = "Top Grossing Titles"
        '
        'MenuStrip1
        '
        Me.MenuStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.HelpToolStripMenuItem})
        Me.MenuStrip1.Location = New System.Drawing.Point(0, 0)
        Me.MenuStrip1.Name = "MenuStrip1"
        Me.MenuStrip1.Size = New System.Drawing.Size(689, 24)
        Me.MenuStrip1.TabIndex = 10
        Me.MenuStrip1.Text = "MenuStrip1"
        '
        'HelpToolStripMenuItem
        '
        Me.HelpToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.AboutToolStripMenuItem, Me.HowToToolStripMenuItem})
        Me.HelpToolStripMenuItem.Name = "HelpToolStripMenuItem"
        Me.HelpToolStripMenuItem.Size = New System.Drawing.Size(44, 20)
        Me.HelpToolStripMenuItem.Text = "Help"
        '
        'AboutToolStripMenuItem
        '
        Me.AboutToolStripMenuItem.Name = "AboutToolStripMenuItem"
        Me.AboutToolStripMenuItem.Size = New System.Drawing.Size(116, 22)
        Me.AboutToolStripMenuItem.Text = "About"
        '
        'HowToToolStripMenuItem
        '
        Me.HowToToolStripMenuItem.Name = "HowToToolStripMenuItem"
        Me.HowToToolStripMenuItem.Size = New System.Drawing.Size(116, 22)
        Me.HowToToolStripMenuItem.Text = "How To"
        '
        'btnClear
        '
        Me.btnClear.DialogResult = System.Windows.Forms.DialogResult.Cancel
        Me.btnClear.Location = New System.Drawing.Point(317, 417)
        Me.btnClear.Name = "btnClear"
        Me.btnClear.Size = New System.Drawing.Size(75, 23)
        Me.btnClear.TabIndex = 11
        Me.btnClear.Text = "Clear"
        Me.btnClear.UseVisualStyleBackColor = True
        '
        'lblGrossTitles
        '
        Me.lblGrossTitles.AutoSize = True
        Me.lblGrossTitles.Location = New System.Drawing.Point(566, 127)
        Me.lblGrossTitles.Name = "lblGrossTitles"
        Me.lblGrossTitles.Size = New System.Drawing.Size(0, 13)
        Me.lblGrossTitles.TabIndex = 12
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(479, 417)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 13
        Me.btnExit.Text = "Exit"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AcceptButton = Me.btnAdd
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.CancelButton = Me.btnClear
        Me.ClientSize = New System.Drawing.Size(689, 529)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.lblGrossTitles)
        Me.Controls.Add(Me.btnClear)
        Me.Controls.Add(Me.lblGross)
        Me.Controls.Add(Me.rtxtDisplay)
        Me.Controls.Add(Me.btnEasy)
        Me.Controls.Add(Me.btnBoxOffice)
        Me.Controls.Add(Me.btntTitle)
        Me.Controls.Add(Me.btnAdd)
        Me.Controls.Add(Me.lblBoxOffice)
        Me.Controls.Add(Me.lblTitle)
        Me.Controls.Add(Me.txtBoxOffice)
        Me.Controls.Add(Me.txtTitle)
        Me.Controls.Add(Me.MenuStrip1)
        Me.MainMenuStrip = Me.MenuStrip1
        Me.Name = "Form1"
        Me.Text = "Program #4"
        Me.MenuStrip1.ResumeLayout(False)
        Me.MenuStrip1.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents txtTitle As System.Windows.Forms.TextBox
    Friend WithEvents txtBoxOffice As System.Windows.Forms.TextBox
    Friend WithEvents lblTitle As System.Windows.Forms.Label
    Friend WithEvents lblBoxOffice As System.Windows.Forms.Label
    Friend WithEvents btnAdd As System.Windows.Forms.Button
    Friend WithEvents btntTitle As System.Windows.Forms.Button
    Friend WithEvents btnBoxOffice As System.Windows.Forms.Button
    Friend WithEvents btnEasy As System.Windows.Forms.Button
    Friend WithEvents rtxtDisplay As System.Windows.Forms.RichTextBox
    Friend WithEvents lblGross As System.Windows.Forms.Label
    Friend WithEvents MenuStrip1 As System.Windows.Forms.MenuStrip
    Friend WithEvents HelpToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents AboutToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents HowToToolStripMenuItem As System.Windows.Forms.ToolStripMenuItem
    Friend WithEvents btnClear As System.Windows.Forms.Button
    Friend WithEvents lblGrossTitles As System.Windows.Forms.Label
    Friend WithEvents btnExit As System.Windows.Forms.Button

End Class
