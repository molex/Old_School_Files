Public Class Form1

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim i As Integer = 0
        Dim j As String
        Dim k As Integer = 0
        Dim p As Integer = 0

        Dim textListArray As String() = {"Unzipping", "Compiling", "Installing", "Deleting C: ", "$2.99", "I am sooo Lazy", "Cleaning up"}

        For Each j In textListArray

            Me.lblText.Text = textListArray(k)
            lblText.Update()
            For i = prgBar1.Minimum To prgBar1.Maximum
                p = (i / 10000)
                Me.lblProgress.Text = p.ToString() + "%"
                lblProgress.Update()
                prgBar1.Value = i

            Next
            k += 1
        Next
        MsgBox("The Program Failed to Install, Don't Worry Scro!")

    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        MsgBox("Can not cancel, data loss imminent!")
    End Sub
End Class
