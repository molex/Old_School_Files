Public Class Form1
    Private Sub btnReverse_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnReverse.Click
        Dim strOriginal As String = Me.txtOriginal.Text
        Dim charArray() As Char = strOriginal.ToCharArray()
        Array.Reverse(charArray)
        Me.txtReverse.Text = charArray
    End Sub
End Class
