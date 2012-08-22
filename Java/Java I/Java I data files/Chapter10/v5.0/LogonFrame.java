















{
    int maxUsers = 3;
    ArrayList userList = new ArrayList();
    User user = null;
    String userName;
    String password;

    JTextField userNameField;
    JPasswordField passwordField;
    JButton jbtAddUser, jbtChgPswd, jbtLogon;

    public LogonFrame()
    {
        super("Log on or Maintain User"); // call super (JFrame) constructor

		int width = 330;
		int height = 170;

		// define GUI components
        JLabel label1 = new JLabel("User Name: ");
        userNameField = new JTextField(20);

        JLabel label2 = new JLabel("Password:   ");
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');

        jbtAddUser = new JButton("Add new user");
        jbtChgPswd = new JButton("Change user pswd");
        jbtLogon = new JButton("Log on");

		// set up GUI
        JPanel userPanel= new JPanel(new BorderLayout());
        userPanel.add(label1,BorderLayout.WEST);
        userPanel.add(userNameField,BorderLayout.CENTER);

        JPanel pswdPanel= new JPanel(new BorderLayout());
        pswdPanel.add(label2,BorderLayout.WEST);
        pswdPanel.add(passwordField,BorderLayout.CENTER);

        JPanel logonButtonPanel= new JPanel(new FlowLayout());
        logonButtonPanel.add(jbtLogon);

        JPanel maintButtonPanel= new JPanel(new FlowLayout());
        maintButtonPanel.add(jbtAddUser);
        maintButtonPanel.add(jbtChgPswd);

        JPanel contentPanel= new JPanel(new BorderLayout());
        contentPanel.add(userPanel, BorderLayout.NORTH);
        contentPanel.add(pswdPanel, BorderLayout.CENTER);
        contentPanel.add(logonButtonPanel, BorderLayout.SOUTH);
    	contentPanel.setBorder(new TitledBorder("Enter User Info"));

        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(contentPanel, BorderLayout.NORTH);
		p2.add(maintButtonPanel, BorderLayout.SOUTH);

        JPanel p3 = new JPanel(new BorderLayout(10,10));
        p3.add(p2, BorderLayout.WEST);
        JPanel p4 = new JPanel(new BorderLayout(10,10));
        p4.add(p3, BorderLayout.EAST);

        setContentPane(p4);

        // add listeners
        jbtAddUser.addActionListener(this);
        jbtChgPswd.addActionListener(this);
        jbtLogon.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
            });

		// Enable Enter key for each JButton
		InputMap map;
		map = jbtAddUser.getInputMap();
		if (map != null){
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
		}
		map = jbtChgPswd.getInputMap();
		if (map != null){
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
		}
		map = jbtLogon.getInputMap();
		if (map != null){
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
		}

        pack();
		if( width < getWidth())				// prevent setting width too small
		   width = getWidth();
		if(height < getHeight())			// prevent setting height too small
			height = getHeight();
		centerOnScreen(width, height);
    }

  	public void centerOnScreen(int width, int height)
  	{
  	  int top, left, x, y;

  	  // Get the screen dimension
  	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  	  // Determine the location for the top left corner of the frame
  	  x = (screenSize.width - width)/2;
  	  y = (screenSize.height - height)/2;
  	  left = (x < 0) ? 0 : x;
  	  top = (y < 0) ? 0 : y;

  	  // Set the frame to the specified location & size
	  this.setBounds(left, top, width, height);
  	}

	private boolean userExists(String userName)
	{
		boolean userInList = false;

        userName.trim(); // remove any leading, trailing whitespace

        if(userList.size()>0) // at least one entry is in list
        {
			for(int i=0; i < userList.size() && !userInList; ++i)
			{
				user = (User)userList.get(i);
			    if(userName.equals(user.getName()))
				    userInList = true;
			}
		}

	    return userInList;
	}

    private boolean addToList(User user)
    {
		boolean success = false;
        if(userList.size() < maxUsers)
            success = userList.add(user);

       return success;
    }

    // enter doStockActivity() method here







	// enter activate() method here







}