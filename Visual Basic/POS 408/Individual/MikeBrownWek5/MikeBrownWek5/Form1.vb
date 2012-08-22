Public Class Form1
    'Author Name:           Mike Brown
    'Date:                  November 23rd, 2009
    'Release Notes:         This is version #1 of this program. 
    '                       I was not able to find a suitable way to sort a 2D array. I did however realize that 2 1D arrays was clearly a better way to 
    '                       attack this problem. I think that I probably could have done this with an arrayList containing the two 1D arrays, but for this
    '                       particular program, I thought the 2 arrays worked well. Also, since my last program crashed due to a "+" sign being in the string
    '                       I decided to simply edit the properties of the Boxx Office Amount text box and not even allow the user to enter anything other than 
    '                       numbers.
    '
    'Program Requirements:  Create a GUI program that allows users to enter info (mission title and adjusted total box office) into a 2-d array. 							'		
    '                       1. Create a form that has 2 text boxes. The first box is for the title and the second is for the adjusted total box office of the mission.		'							
    '                       2. Create an 'add' button to insert the data from the textboxes into a 2d array. Ensure to check for valid entries before you insert the data. 	'		
    '                       3. As the user ‘adds’ data info the array, display the info in a text area. Ensure to update the text area as the user enters additional info	'
    '
    '                       4. Create 2 buttons that allows users to sort the 2d array by ‘year’ or ‘adjustd total box office.’ contents.									'                          Ensure the text area is updated with the newly sorted array 	
    '
    '                       5. Allow for a quick load option for loading all of the documented 22 missions. 										
    '                          Create a red colored button called ‘Easy button’ that automatically populated the 2d array with all of the information and displays onto t     '                          the text area.
    '
    '                       6. When there are 3 entries in the array, display on a label the 'titles' of the top 30% highest adjusted total box office missions listed        '                          from high to low 				
    '						
    '                       7. Ensure that users are able to see all of the data by creating scroll bars. 	
    '
    '                       8. Ensure to provide instruction to the user of how to use the program. Create a menu bar item which contains a ‘help’ function.			      '					
    '

    'Initialize Public Arrays for the Title and Box Office Amounts. 
    Dim strTitleArray() As String
    Dim dblBoxOfficeArray() As Double

    'Also create counters for the number of Elements in those Arrays
    Dim strElements As Integer = 0
    Dim dblElements As Integer = 0




    Private Sub txtBoxOffice_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles txtBoxOffice.KeyPress
        'This controls the Box Office Text Box. If the user enters any key that is not a number, they will get a messsage that tells them they can only enter numbers
        If (Microsoft.VisualBasic.Asc(e.KeyChar) < 48) _
                  Or (Microsoft.VisualBasic.Asc(e.KeyChar) > 57) Then
            e.Handled = True
            MsgBox("You can only enter numbers here!")
            txtBoxOffice.Focus()
        End If
        If (Microsoft.VisualBasic.Asc(e.KeyChar) = 8) Then
            e.Handled = False
        End If
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
        Help.ShowHelp(Me, Application.StartupPath & "\week5.chm")
    End Sub


    Private Sub btnAdd_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnAdd.Click
        'create variable to store the Text from the texboxes
        Dim dblBoxOffice As Double
        Dim strBoxOffice As String = Me.txtBoxOffice.Text
        Dim strTitle As String = Me.txtTitle.Text.Trim()

        'check to ensure that the data entered is a number
        If IsNumeric(strBoxOffice) Then
            dblBoxOffice = Convert.ToDouble(strBoxOffice)

            If strTitle Is Nothing Then
                MsgBox("Movie Title Can not be Blank")
                txtTitle.Focus()
            ElseIf strTitle = "" Then
                MsgBox("Movie Title Can not be Blank")
                txtTitle.Clear()
                txtTitle.Focus()
            ElseIf strTitle = " " Then
                MsgBox("Movie Title Can not be Blank")
                txtTitle.Clear()
                txtTitle.Focus()
            Else

                'insert the data into their Arrays
                addToStrArray(strTitle)
                addToDblArray(dblBoxOffice)

                'update the Rich Text Box with the new array information
                updateDisplay()

                txtTitle.Focus()
            End If


        Else
            'this should never happen because I locked all keys except for the numeric ones :)
            MsgBox("Please enter a valid dollar amount")
            txtBoxOffice.Clear()
            txtBoxOffice.Focus()

        End If

    End Sub

    Private Sub btnTitle_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btntTitle.Click
        'sort the array by title, then sort the box office array in the same order as the title array
        Array.Sort(strTitleArray, dblBoxOfficeArray)

        'rewrite the rich text box to show updated results
        updateDisplay()

    End Sub

    Private Sub btnEasy_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnEasy.Click
        'clear out any old data
        txtTitle.Clear()
        txtBoxOffice.Clear()
        rtxtDisplay.Clear()

        'hard coded Bond Movie Titles
        Dim strTitleArrayEasy() As String = {"Dr. No", "From Russia with Love", "Goldfinger", "Thunderball", "You Only Live Twice", "On Her Majesty's Secret Service", "Diamonds Are Forever", "Live and Let Die", "The Man with the Golden Gun", "The Spy Who Loved Me", "Moonraker", "For Your Eyes Only", "Octopussy", "A View to a Kill", "The Living Daylights", "Licence to Kill", "GoldenEye", "Tomorrow Never Dies", "The World Is Not Enough", "Die Another Day", "Casino Royale", "Quantum of Solace"}

        'set the title array as a clone of the hard coded array
        strTitleArray = strTitleArrayEasy.Clone

        'hard coded Bond Box Offices
        Dim dblBoxOfficeEasy() As Double = {425488741, 555909803, 868659354, 966435555, 720388023, 513445231, 617520987, 785677477, 426826774, 666367656, 624527272, 481005579, 405873493, 316186616, 362876056, 271586451, 499954330, 465588535, 504705882, 546490272, 640803677, 586090727}

        'set the box office array as a clone of the hard coded one
        dblBoxOfficeArray = dblBoxOfficeEasy.Clone

        'rewrite the rich text box to show new results
        updateDisplay()

    End Sub
    Sub addToStrArray(ByVal strTitle As String)
        'resize array and preserve previous data
        ReDim Preserve strTitleArray(strElements)

        'add new item to array
        strTitleArray(strElements) = strTitle

        'increase overal array size
        strElements += 1
    End Sub
    Sub addToDblArray(ByVal dblBoxOffice As Double)
        'resize array and preserve previous data
        ReDim Preserve dblBoxOfficeArray(dblElements)

        'add new item to array
        dblBoxOfficeArray(dblElements) = dblBoxOffice

        'increase overal array size
        dblElements += 1
    End Sub

    Sub displayTopGross()
        'clear any old data
        lblGrossTitles.Text = ""
        'ensure that the array is sorted by box office amount
        Array.Sort(dblBoxOfficeArray, strTitleArray)
        'rearrange arrays to be from highest to lowest box office amounts
        Array.Reverse(dblBoxOfficeArray)
        Array.Reverse(strTitleArray)

        'create variables to determine top 30 percent
        Dim i As Integer
        Dim titlesToDisplay As Double

        'find out how many titles there are and then multiply by .3 (30%) to get a total number of titles to display
        titlesToDisplay = (dblBoxOfficeArray.Length * 0.3)

        'in case the number is a decimal, convert to int 
        Dim actualTitles As Integer = Convert.ToInt32(titlesToDisplay)

        'loop through array and add the neccesary titles to the label
        For i = 0 To actualTitles - 1 Step i + 1
            lblGrossTitles.Text += strTitleArray(i) + vbNewLine
        Next

    End Sub



    Private Sub btnClear_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnClear.Click
        'create integer variables to hold the length of the arrays to be used for Array.Clear()

        'Dim strLength As Integer = strTitleArray.Length
        'Dim dblLength As Integer = dblBoxOfficeArray.Length
        'clear all data from Arrays, text boxes, rich text boxes, and labels
        txtTitle.Clear()
        txtBoxOffice.Clear()
        rtxtDisplay.Clear()
        lblGrossTitles.Text = ""

        If strTitleArray Is Nothing Then
            'don't attempt to clear an empty array
            'Do Nothing
        Else
            'clear the arrays
            Array.Clear(strTitleArray, 0, strElements)
            Array.Clear(dblBoxOfficeArray, 0, dblElements)
        End If

       
    End Sub


    Private Sub btnBoxOffice_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnBoxOffice.Click
        'sort the array by box office, then sort the title array in the same order as the box office array
        Array.Sort(dblBoxOfficeArray, strTitleArray)

        'rewrite the rich text box with new updates
        updateDisplay()

    End Sub

    Sub updateDisplay()
        'clear old data
        txtBoxOffice.Clear()
        txtTitle.Clear()
        rtxtDisplay.Clear()

        'Create loop variables
        Dim strItem As String
        Dim count As Integer = 0

        rtxtDisplay.Text = "Title" + Space(45) + "Box Office Amount" + vbNewLine
        'loop through the strTitleArray and write all the titles to the rich text box. Also use the count variable to loop through the box office array
        'and write to the text box
        For Each strItem In strTitleArray

            While strItem.Length < 50
                strItem += "."
            End While

            rtxtDisplay.Text += strItem + dblBoxOfficeArray(count).ToString("C") + vbNewLine
            count += 1
        Next

        'add items to the top grossing label is there are more than 3 items in the array
        If (strTitleArray.Length >= 3) Then
            displayTopGross()
        End If
    End Sub


    Private Sub btnExit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnExit.Click
        'exit the program
        Me.Close()
    End Sub
End Class
