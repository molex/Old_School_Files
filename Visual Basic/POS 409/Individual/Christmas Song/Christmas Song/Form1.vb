Public Class Form1
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim days() As String = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"}
        Dim presents() As String = {"a partridge in a pear tree", "two turtle doves, and ", "three french hens, ", "four calling birds, ", "five gold rings, ", _
            "six geese a-laying, ", "seven swans a-swimming, ", "eigth maids a-milking, ", "nine ladies dancing, ", "ten lords a-leaping, ", "eleven pipers piping, ", _
            "twelve drummers drumming, "}
        Dim i As Integer
        Dim cumulativeGifts As String = ""
        For i = 0 To 11
            cumulativeGifts = presents(i) & cumulativeGifts
            Me.rtxtSong.Text += "On the " + days(i) + " day of Christmas, my true love gave to me: " + vbNewLine + cumulativeGifts.ToString() + vbNewLine + vbNewLine
        Next
    End Sub
End Class
