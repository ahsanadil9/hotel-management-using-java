import java.awt.event.KeyEvent;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
//-----------------------------------------------------------------------------------------------------------------------------------------------------





//-----------------------------------------------------------------------------------------------------------------------------------------------------
public class Room extends javax.swing.JFrame { //here I have build connection to connect mysql from hosting....
  
    public Room(){
        initComponents(); //initializing form 
        Connect(); //then call this method 
        autoId(); //when the form is loaded, this function get loaded
        
        show_RoomTble(); //will show output to our table 
        Mydate();
        
    }
    
    Connection con = null;
    PreparedStatement pst = null;
    DefaultTableModel d;
//-----------------------------------------------------------------------------------------------------------------------------------------------------

  public void Mydate()
  {
          Rbdate.setEditable(false);//date in rbdate
        SimpleDateFormat myformat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        Rbdate.setText(myformat.format(cal.getTime()));
  }


    
//-----------------------------------------------------------------------------------------------------------------------------------------------------
  
    public void Connect() //Calling Connect Method, this is our database connection when the form is loaded
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");           
            
                //obj con, database is reside in our local host and inside localhost whats database name whic is luxuryhotel  user=root password=blank
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/luxuryhotel","root","");
            
                         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------
  
  

    
//-----------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void autoId()
    {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select MAX(Rb) from roomTble");
            rs.next();
            rs.getString("MAX(Rb)");
            if(rs.getString("MAX(Rb)") ==  null)
            {
                jLabel5.setText("A0001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(Rb)").substring(1, rs.getString("MAX(Rb)").length()));
                id++;
                jLabel5.setText("A0" + String.format("%03d", id)); // add "%03d" to add 3 leading zeros in an Integer.
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------
    
    
 
    
@SuppressWarnings("unchecked")   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Rprice = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Rdur = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Rroom = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        Rcat = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbleRoom = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        Rstat = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Rbdate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add.setText("ADD");
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addKeyPressed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 660, 80, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Status");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, 30));

        edit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edit.setText("EDIT");
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        edit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editKeyPressed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 660, 80, 30));

        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                deleteKeyTyped(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 660, 80, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Rooms");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(163, 249, 249));
        jLabel4.setText("ZARH LUXURY HOTEL MANAGEMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 43, -1, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Duration");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, -1, 30));

        Rprice.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Rprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RpriceActionPerformed(evt);
            }
        });
        getContentPane().add(Rprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, 110, 30));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Category");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Date: (D/M/Y)");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, -1, 30));

        Rdur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 Hrs", "6 Hrs", "12 Hrs", "1 Day", "3 Days", "7 Days", "2 Weeks", "1 Month", "3 Months", " " }));
        Rdur.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Rdur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RdurActionPerformed(evt);
            }
        });
        getContentPane().add(Rdur, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 110, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Room Booking");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 260, -1));

        Rroom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        Rroom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Rroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RroomActionPerformed(evt);
            }
        });
        getContentPane().add(Rroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 110, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Amount");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, -1, 30));

        Rcat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single ", "Double ", "King Double ", "Deluxe ", "Suite " }));
        Rcat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Rcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RcatActionPerformed(evt);
            }
        });
        getContentPane().add(Rcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 110, 30));

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TbleRoom.setBorder(new javax.swing.border.MatteBorder(null));
        TbleRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TbleRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No.", "Type", "Room", "Status", "Duration", "Booking Date", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TbleRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbleRoomMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbleRoom);
        if (TbleRoom.getColumnModel().getColumnCount() > 0) {
            TbleRoom.getColumnModel().getColumn(0).setMinWidth(80);
            TbleRoom.getColumnModel().getColumn(0).setMaxWidth(100);
            TbleRoom.getColumnModel().getColumn(1).setMinWidth(80);
            TbleRoom.getColumnModel().getColumn(1).setMaxWidth(100);
            TbleRoom.getColumnModel().getColumn(2).setMinWidth(80);
            TbleRoom.getColumnModel().getColumn(2).setMaxWidth(100);
            TbleRoom.getColumnModel().getColumn(3).setMinWidth(80);
            TbleRoom.getColumnModel().getColumn(3).setMaxWidth(100);
            TbleRoom.getColumnModel().getColumn(4).setMinWidth(80);
            TbleRoom.getColumnModel().getColumn(4).setMaxWidth(100);
            TbleRoom.getColumnModel().getColumn(5).setMinWidth(80);
            TbleRoom.getColumnModel().getColumn(5).setMaxWidth(110);
            TbleRoom.getColumnModel().getColumn(6).setMinWidth(80);
            TbleRoom.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 700, 300));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Room No");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, 30));

        Rstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Free " }));
        Rstat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Rstat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RstatActionPerformed(evt);
            }
        });
        getContentPane().add(Rstat, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 110, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("    jLabel5");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 110, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 660, 80, 30));

        Rbdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Rbdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbdateActionPerformed(evt);
            }
        });
        getContentPane().add(Rbdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 110, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LuxuryImages/blueBackground.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 1050, 460));

        jButton2.setBackground(new java.awt.Color(233, 232, 232));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LuxuryImages/back.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background3.jpeg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -20, 1330, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents
     


    
//-----------------------------------------------------------------------------------------------------------------------------------------------------
        //displaying output in our table 
    public void show_RoomTble()                                    
        {
        try {
            pst = con.prepareStatement("select * from roomTble");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();    
            d = (DefaultTableModel)TbleRoom.getModel();
            d.setRowCount(0);
            while(rs.next())
            {
                Vector v2 = new Vector();
                for (int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("Rb"));
                    v2.add(rs.getString("Rcat"));
                    v2.add(rs.getString("Rroom"));
                    v2.add(rs.getString("Rstat"));
                    v2.add(rs.getString("Rdur"));
                    v2.add(rs.getString("Rbdate"));
                    v2.add(rs.getString("Rprice"));
                }
                    
                    d.addRow(v2);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }
 
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    
    

    
//-----------------------------------------------------------------------------------------------------------------------------------------------------    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Rcat.setSelectedIndex(-1);
        Rroom.setSelectedIndex(-1);
        Rstat.setSelectedIndex(-1);
        Rdur.setSelectedIndex(-1);
        Rbdate.setText("");
        Rprice.setText("");
        autoId();
        show_RoomTble();
       
    }//GEN-LAST:event_jButton1ActionPerformed
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    
    
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------    
    private void TbleRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbleRoomMouseClicked
        d = (DefaultTableModel)TbleRoom.getModel();
        int selectIndex = TbleRoom.getSelectedRow();
        
        jLabel5.setText(d.getValueAt(selectIndex, 0).toString());
        Rcat.setSelectedItem(d.getValueAt(selectIndex, 1).toString());
        Rroom.setSelectedItem(d.getValueAt(selectIndex, 2).toString());
        Rstat.setSelectedItem(d.getValueAt(selectIndex, 3).toString());
        Rdur.setSelectedItem(d.getValueAt(selectIndex, 4).toString());
        Rbdate.setText(d.getValueAt(selectIndex, 5).toString());
        Rprice.setText(d.getValueAt(selectIndex, 6).toString());
        add.setEnabled(false);

    }//GEN-LAST:event_TbleRoomMouseClicked
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    
    
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        String roomNo = jLabel5.getText();

   
        try {
            pst = con.prepareStatement("delete from roomTble where Rb = ?");
            //prepared statement all of the strings by setString method..

            pst.setString(1, roomNo);
            pst.executeUpdate(); //here our pst statement will execute.

            //displaying message of Room is Added Successfully..
            JOptionPane.showMessageDialog(null, "Room Deleted !!");

            //here we are clearing all the input data from our roomTble which will set to blank
            Rcat.setSelectedIndex(-1);
            Rroom.setSelectedIndex(-1);
            Rstat.setSelectedIndex(-1);
            Rdur.setSelectedIndex(-1);
            Rbdate.setText("");
            Rprice.setText("");
            autoId();
            show_RoomTble();
            add.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_deleteActionPerformed
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    
    
    
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------    
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        //calling variable with their method and storing them into new variable..
        String roomNo = jLabel5.getText();
        String category = Rcat.getSelectedItem().toString();
        String totalRoom = Rroom.getSelectedItem().toString();
        String status = Rstat.getSelectedItem().toString();
        String duration = Rdur.getSelectedItem().toString();
        String bookingDate = Rbdate.getText();
        String amount = Rprice.getText();

        if(Rcat.getSelectedIndex() == -1 || Rroom.getSelectedIndex() == -1 || Rstat.getSelectedIndex() == -1 || Rdur.getSelectedIndex() == -1 ||
            Rbdate.getText().isEmpty() || Rprice.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Edit Data!!!");
        }
        else
        {
            try {
                pst = con.prepareStatement("update roomTble set Rcat = ?, Rroom = ?, Rstat = ?, Rdur = ?, Rbdate = ?, Rprice = ? where Rb = ?");
                //prepared statement all of the strings by setString method..

                pst.setString(1, category);
                pst.setString(2, totalRoom);
                pst.setString(3, status);
                pst.setString(4, duration);
                pst.setString(5, bookingDate);
                pst.setString(6, amount);
                pst.setString(7, roomNo);
                pst.executeUpdate(); //here our pst statement will execute.

                //displaying message of Room is Added Successfully..
                JOptionPane.showMessageDialog(this, "Room Edited !!");

                //here we are clearing all the input data from our roomTble which will set to blank
                Rcat.setSelectedIndex(-1);
                Rroom.setSelectedIndex(-1);
                Rstat.setSelectedIndex(-1);
                Rdur.setSelectedIndex(-1);
                Rprice.setText("");
                autoId();
                show_RoomTble();
                add.setEnabled(true);

            } catch (SQLException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Edit button Functionality is here..       
    }//GEN-LAST:event_editActionPerformed
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    
    
    

//-----------------------------------------------------------------------------------------------------------------------------------------------------
                                    
 private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //calling variable with their method and storing them into new variable..
        String roomNo = jLabel5.getText();
        String category = Rcat.getSelectedItem().toString();
        String totalRoom = Rroom.getSelectedItem().toString();
        String status = Rstat.getSelectedItem().toString();
        String duration = Rdur.getSelectedItem().toString();
        String bookingDate = Rbdate.getText();
        String amount = Rprice.getText();
        
if(Rcat.getSelectedIndex() == -1 || Rroom.getSelectedIndex() == -1 || Rstat.getSelectedIndex() == -1 || Rdur.getSelectedIndex() == -1 || 
        Rbdate.getText().isEmpty() || Rprice.getText().isEmpty())
   {
       JOptionPane.showMessageDialog(this, "Missing Data!!!");            
   }
else{
        try {
            pst = con.prepareStatement("insert into roomTble(Rb, Rcat, Rroom, Rstat, Rdur, Rbdate, Rprice) values(?,?,?,?,?,?,?)");
            //prepared statement all of the strings by setString method..
            pst.setString(1, roomNo);
            pst.setString(2, category);
            pst.setString(3, totalRoom);
            pst.setString(4, status);
            pst.setString(5, duration);
            pst.setString(6, bookingDate);
            pst.setString(7, amount);
            pst.executeUpdate(); //here our pst statement will execute.
            
            //displaying message of Room is Added Successfully..
            JOptionPane.showMessageDialog(this, "Room Added !!");
            
            //here we are clearing all the input data from our roomTble which will set to blank
            Rcat.setSelectedIndex(-1);
            Rroom.setSelectedIndex(-1);
            Rstat.setSelectedIndex(-1);
            Rdur.setSelectedIndex(-1);
            Rprice.setText("");
            autoId();
            show_RoomTble();
           
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }       
        //Add button Functionality is here..
    }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------


//GEN-LAST:event_addActionPerformed

 
//----------------------------------------------------------------------------------------------------------------------------------------------------- 
    private void RstatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RstatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RstatActionPerformed

    private void RcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RcatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RcatActionPerformed

    private void RroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RroomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RroomActionPerformed

    private void RdurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RdurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RdurActionPerformed

    private void RpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RpriceActionPerformed
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    
    
    
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------    
    //ENTER KEY FOR ADD BUTTON
    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_addKeyPressed
//-----------------------------------------------------------------------------------------------------------------------------------------------------
   
//-----------------------------------------------------------------------------------------------------------------------------------------------------    
    private void editKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_editKeyPressed
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    
    
    
    
    private void deleteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_deleteKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new AdminPanel().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void RbdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbdateActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_RbdateActionPerformed

    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Rbdate;
    private javax.swing.JComboBox<String> Rcat;
    private javax.swing.JComboBox<String> Rdur;
    private javax.swing.JTextField Rprice;
    private javax.swing.JComboBox<String> Rroom;
    private javax.swing.JComboBox<String> Rstat;
    private javax.swing.JTable TbleRoom;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

   
}
