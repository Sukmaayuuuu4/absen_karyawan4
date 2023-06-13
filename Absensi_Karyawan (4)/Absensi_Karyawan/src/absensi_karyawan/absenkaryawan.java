
package absensi_karyawan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class absenkaryawan extends javax.swing.JFrame {
    
    
    
    public absenkaryawan() {
        initComponents();
        loaddata();
        loadabsenmsuk();
        loadabsenkeluar();
        loaddataizin();
        loaddataizinacc();
        showdate();
        showtime();
    }
    
    
    public void loaddata(){
        DefaultTableModel tbl =new DefaultTableModel();
        tbl.addColumn("ID karyawan");
        tbl.addColumn("Nama");
        tbl.addColumn("Jabatan");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Kontak");
        //tbl.addColumn("Pin");
        
        try {
            Connection con = (Connection) koneksi.getConnections();
            
            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM data_karyawan");
            
            while(rs.next()){
                tbl.addRow(new Object[] {
                    rs.getString("id_karyawan"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("kontak")
                    //rs.getString("pin")
                });
                jTable1.setModel(tbl);
               
            }
            
            
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }
    
    public void loadabsenmsuk(){
        DefaultTableModel tbl =new DefaultTableModel();
        tbl.addColumn("ID karyawan");
        tbl.addColumn("Time");
        tbl.addColumn("Date");
        
        try {
            Connection con = (Connection) koneksi.getConnections();
            
            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM absen_masuk");
            
            while(rs.next()){
                tbl.addRow(new Object[] {
                    rs.getString("id_karyawana"),
                    rs.getString("time"),
                    rs.getString("date")
                   
                });
                Tababsenmasuk.setModel(tbl);
               
            }
            
            
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }
    
    public void loadabsenkeluar(){
        DefaultTableModel tbl =new DefaultTableModel();
        tbl.addColumn("ID karyawan");
        tbl.addColumn("Time");
        tbl.addColumn("Date");
        
        try {
            Connection con = (Connection) koneksi.getConnections();
            
            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM absen_keluar");
            
            while(rs.next()){
                tbl.addRow(new Object[] {
                    rs.getString("id_karyawanq"),
                    rs.getString("timer"),
                    rs.getString("dater")
                   
                });
                Tababsenkeluar.setModel(tbl);
               
            }
            
            
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }
    
    public void loaddataizin(){
        DefaultTableModel tbl =new DefaultTableModel();
        tbl.addColumn("ID karyawan");
        tbl.addColumn("Keterangan");
        tbl.addColumn("Detail keterangan");
        tbl.addColumn("Mulai tanggal");
        tbl.addColumn("Hingga tanggal");
    
        try {
            Connection con = (Connection) koneksi.getConnections();
            
            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM izin");
            
            while(rs.next()){
                tbl.addRow(new Object[] {
                    rs.getString("id_karyawan"),
                    rs.getString("alasan"),
                    rs.getString("detail"),
                    rs.getString("mulaitanggal"),
                    rs.getString("hinggatanggal")
                   
                });
                Tabizin1.setModel(tbl);
               
            }
            
            
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
        
    }
    
    public void loaddataizinacc(){
        DefaultTableModel tbl =new DefaultTableModel();
        tbl.addColumn("ID karyawan");
        tbl.addColumn("Keterangan");
        tbl.addColumn("Detail keterangan");
        tbl.addColumn("Mulai tanggal");
        tbl.addColumn("Hingga tanggal");
    
        try {
            Connection con = (Connection) koneksi.getConnections();
            
            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM accepted_izin");
            
            while(rs.next()){
                tbl.addRow(new Object[] {
                    rs.getString("id_karyawan"),
                    rs.getString("alasan"),
                    rs.getString("detail"),
                    rs.getString("mulaitanggal"),
                    rs.getString("hinggatanggal")
                   
                });
                Tabizin.setModel(tbl);
               
            }
            
            
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
        
    }
    
    public void showdate(){
    
        java.util.Date d = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dat = sdf.format(d);
        Tdate.setText(dat);
        
    }
    
    public void showtime(){
    
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date d = new java.util.Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss");
                String tim = sdf.format(d);
                Ttime.setText(tim);
            }
        }).start();
        
    }
    
    void clear(){
        Tidkaryawan.setText("");
        Tnama.setText("");
        cbjabatan.setSelectedIndex(-1);
        cbkelamin.setSelectedIndex(-1);
        Tkontak.setText("");
        pwpindata.setText("");
    }
    
    void clearlogin(){
        Tusernameadmin.setText("");
        pwadminlogin.setText("");
    }
    
    void clearloginabsen(){
        Tidkaryawanabsen.setText("");
        pwpinabsen.setText("");
    }
    
    void clearizin(){
        Tidkaryawanzin.setText("");
        pwpinizin.setText("");
        cbalasan.setSelectedIndex(-1);
        Tdetail.setText("");
        Tidtanggalmulai.setText("");
        Tidtanggalhingga.setText("");
    }
    
    void clearizinacc(){
        Tidkaryawanzin1.setText("");
        cbalasan1.setSelectedIndex(-1);
        Tdetail1.setText("");
        Tidtanggalmulai1.setText("");
        Tidtanggalhingga1.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Tidkaryawan = new javax.swing.JTextField();
        Tnama = new javax.swing.JTextField();
        Tkontak = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cbjabatan = new javax.swing.JComboBox<>();
        cbkelamin = new javax.swing.JComboBox<>();
        savebutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        Lpindata = new javax.swing.JLabel();
        pwpindata = new javax.swing.JPasswordField();
        clearbutton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Lalasan = new javax.swing.JLabel();
        Lidkaryawanalasan = new javax.swing.JLabel();
        Tidkaryawanzin = new javax.swing.JTextField();
        Lmulaitanggal = new javax.swing.JLabel();
        Lhinggatanggal = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabizin = new javax.swing.JTable();
        PINizin = new javax.swing.JLabel();
        pwpinizin = new javax.swing.JPasswordField();
        cbalasan = new javax.swing.JComboBox<>();
        abseninbutton1 = new javax.swing.JButton();
        Tidtanggalmulai = new javax.swing.JTextField();
        Tidtanggalhingga = new javax.swing.JTextField();
        Lalasan2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tdetail = new javax.swing.JTextArea();
        abseninbutton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlabelabsen = new javax.swing.JLabel();
        Ltime = new javax.swing.JLabel();
        Ldate = new javax.swing.JLabel();
        Lidkaryawanabsen = new javax.swing.JLabel();
        Tidkaryawanabsen = new javax.swing.JTextField();
        abseninbutton = new javax.swing.JButton();
        absenoutbutton = new javax.swing.JButton();
        Ttime = new javax.swing.JTextField();
        Tdate = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tababsenmasuk = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tababsenkeluar = new javax.swing.JTable();
        Tpinabsen = new javax.swing.JLabel();
        pwpinabsen = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        Lkoginadmin = new javax.swing.JLabel();
        Lusernameadmin = new javax.swing.JLabel();
        Tusernameadmin = new javax.swing.JTextField();
        Lpasswordadmin = new javax.swing.JLabel();
        pwadminlogin = new javax.swing.JPasswordField();
        Buttonloginadmin = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Lkoginadmin1 = new javax.swing.JLabel();
        Lusernameadmin1 = new javax.swing.JLabel();
        Tusernameadmin1 = new javax.swing.JTextField();
        Lpasswordadmin1 = new javax.swing.JLabel();
        pwadminlogin1 = new javax.swing.JPasswordField();
        Buttonloginadmin1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        Lkoginadmin2 = new javax.swing.JLabel();
        Lidkaryawanalasan1 = new javax.swing.JLabel();
        Lalasan1 = new javax.swing.JLabel();
        cbalasan1 = new javax.swing.JComboBox<>();
        Tidkaryawanzin1 = new javax.swing.JTextField();
        Lmulaitanggal1 = new javax.swing.JLabel();
        Lhinggatanggal1 = new javax.swing.JLabel();
        Tidtanggalmulai1 = new javax.swing.JTextField();
        Tidtanggalhingga1 = new javax.swing.JTextField();
        Lalasan3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tdetail1 = new javax.swing.JTextArea();
        abseninbutton2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        Tabizin1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setForeground(new java.awt.Color(51, 51, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(243, 10000));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ABSENSI");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("KARYAWAN");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("DATA KARYAWAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("IZIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setText("ABSENSI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("BETA");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 255));
        jButton4.setText("MENU UTAMA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 255));
        jButton5.setText("ACCEPT IZIN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(" KARYAWAN");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("      ADMIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(5, 5, 5)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(35, 35, 35)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(364, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 850));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 255));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1600, 1400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 10000));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("MENU UTAMA");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(1600, 10000));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("MENU UTAMA");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addContainerGap(1345, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addContainerGap(9926, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("DATA KARYAWAN");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("NAMA");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("ID KARYAWAN");

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("JABATAN");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("JENIS KELAMIN");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("KONTAK");

        Tidkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidkaryawanActionPerformed(evt);
            }
        });

        Tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnamaActionPerformed(evt);
            }
        });

        Tkontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TkontakActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cbjabatan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cbjabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "ceo", "supervisor", "karyawan", "office boy" }));
        cbjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjabatanActionPerformed(evt);
            }
        });

        cbkelamin.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cbkelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "laki-laki", "perempuan", "transformer" }));
        cbkelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkelaminActionPerformed(evt);
            }
        });

        savebutton.setBackground(new java.awt.Color(255, 255, 255));
        savebutton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        savebutton.setForeground(new java.awt.Color(51, 51, 255));
        savebutton.setText("SAVE");
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });

        editbutton.setBackground(new java.awt.Color(255, 255, 255));
        editbutton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        editbutton.setForeground(new java.awt.Color(51, 51, 255));
        editbutton.setText("EDIT");
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });

        deletebutton.setBackground(new java.awt.Color(255, 255, 255));
        deletebutton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deletebutton.setForeground(new java.awt.Color(51, 51, 255));
        deletebutton.setText("DELETE");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        clearbutton.setBackground(new java.awt.Color(255, 255, 255));
        clearbutton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        clearbutton.setForeground(new java.awt.Color(51, 51, 255));
        clearbutton.setText("CLEAR");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        Lpindata.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lpindata.setForeground(new java.awt.Color(51, 51, 255));
        Lpindata.setText("PIN");

        pwpindata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwpindataActionPerformed(evt);
            }
        });

        clearbutton1.setBackground(new java.awt.Color(255, 255, 255));
        clearbutton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        clearbutton1.setForeground(new java.awt.Color(51, 51, 255));
        clearbutton1.setText("CHANGE PIN");
        clearbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbutton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 90, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(Lpindata))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(pwpindata, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Tkontak, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                                        .addGap(34, 34, 34)
                                        .addComponent(clearbutton1))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbjabatan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbkelamin, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(savebutton)
                        .addGap(18, 18, 18)
                        .addComponent(editbutton)
                        .addGap(18, 18, 18)
                        .addComponent(deletebutton)
                        .addGap(18, 18, 18)
                        .addComponent(clearbutton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Tidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(cbjabatan)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbkelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tkontak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lpindata, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwpindata, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbutton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savebutton)
                    .addComponent(editbutton)
                    .addComponent(deletebutton)
                    .addComponent(clearbutton))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("IZIN");

        Lalasan.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lalasan.setForeground(new java.awt.Color(51, 51, 255));
        Lalasan.setText("KETERANGAN");

        Lidkaryawanalasan.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lidkaryawanalasan.setForeground(new java.awt.Color(51, 51, 255));
        Lidkaryawanalasan.setText("ID KARYAWAN");

        Tidkaryawanzin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidkaryawanzinActionPerformed(evt);
            }
        });

        Lmulaitanggal.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lmulaitanggal.setForeground(new java.awt.Color(51, 51, 255));
        Lmulaitanggal.setText("MULAI TANGGAL");

        Lhinggatanggal.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lhinggatanggal.setForeground(new java.awt.Color(51, 51, 255));
        Lhinggatanggal.setText("HINGGA TANGGAL");

        Tabizin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(Tabizin);

        PINizin.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        PINizin.setForeground(new java.awt.Color(51, 51, 255));
        PINizin.setText("PIN");

        pwpinizin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwpinizinActionPerformed(evt);
            }
        });

        cbalasan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cbalasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "sakit", "cuti", "cuti melahirkan" }));

        abseninbutton1.setBackground(new java.awt.Color(255, 255, 255));
        abseninbutton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        abseninbutton1.setForeground(new java.awt.Color(51, 51, 255));
        abseninbutton1.setText("SUBMIT");
        abseninbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abseninbutton1ActionPerformed(evt);
            }
        });

        Tidtanggalmulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidtanggalmulaiActionPerformed(evt);
            }
        });

        Tidtanggalhingga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidtanggalhinggaActionPerformed(evt);
            }
        });

        Lalasan2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lalasan2.setForeground(new java.awt.Color(51, 51, 255));
        Lalasan2.setText("DETAIL KETERANGAN");

        Tdetail.setColumns(20);
        Tdetail.setRows(5);
        jScrollPane5.setViewportView(Tdetail);

        abseninbutton3.setBackground(new java.awt.Color(255, 255, 255));
        abseninbutton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        abseninbutton3.setForeground(new java.awt.Color(51, 51, 255));
        abseninbutton3.setText("REFRESH");
        abseninbutton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abseninbutton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PINizin)
                    .addComponent(Lalasan)
                    .addComponent(Lidkaryawanalasan)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lhinggatanggal)
                            .addComponent(Lmulaitanggal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbalasan, 0, 122, Short.MAX_VALUE)
                            .addComponent(pwpinizin, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(Tidkaryawanzin, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(Tidtanggalmulai)
                            .addComponent(Tidtanggalhingga, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lalasan2)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(abseninbutton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(abseninbutton1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tidkaryawanzin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lidkaryawanalasan)
                    .addComponent(Lalasan2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PINizin)
                            .addComponent(pwpinizin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lalasan)
                            .addComponent(cbalasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lmulaitanggal)
                    .addComponent(Tidtanggalmulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lhinggatanggal)
                    .addComponent(Tidtanggalhingga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abseninbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abseninbutton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentShown(evt);
            }
        });

        jlabelabsen.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jlabelabsen.setForeground(new java.awt.Color(51, 51, 255));
        jlabelabsen.setText("ABSENSI");

        Ltime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Ltime.setForeground(new java.awt.Color(51, 51, 255));
        Ltime.setText("TIME");

        Ldate.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Ldate.setForeground(new java.awt.Color(51, 51, 255));
        Ldate.setText("DATE");

        Lidkaryawanabsen.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lidkaryawanabsen.setForeground(new java.awt.Color(51, 51, 255));
        Lidkaryawanabsen.setText("ID KARYAWAN");

        Tidkaryawanabsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidkaryawanabsenActionPerformed(evt);
            }
        });

        abseninbutton.setBackground(new java.awt.Color(255, 255, 255));
        abseninbutton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        abseninbutton.setForeground(new java.awt.Color(51, 51, 255));
        abseninbutton.setText("ABSEN MASUK");
        abseninbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abseninbuttonActionPerformed(evt);
            }
        });

        absenoutbutton.setBackground(new java.awt.Color(255, 255, 255));
        absenoutbutton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        absenoutbutton.setForeground(new java.awt.Color(51, 51, 255));
        absenoutbutton.setText("ABSEN KELUAR");
        absenoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absenoutbuttonActionPerformed(evt);
            }
        });

        Ttime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtimeActionPerformed(evt);
            }
        });

        Tdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TdateActionPerformed(evt);
            }
        });

        Tababsenmasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Tababsenmasuk);

        Tababsenkeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(Tababsenkeluar);

        Tpinabsen.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Tpinabsen.setForeground(new java.awt.Color(51, 51, 255));
        Tpinabsen.setText("PIN");

        pwpinabsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwpinabsenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Lidkaryawanabsen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tidkaryawanabsen, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(Tpinabsen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pwpinabsen, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlabelabsen)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ldate)
                            .addComponent(Ltime))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ttime, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(abseninbutton))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(absenoutbutton)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlabelabsen)
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Ltime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ldate))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(Ttime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lidkaryawanabsen)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Tidkaryawanabsen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tpinabsen)
                        .addComponent(pwpinabsen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abseninbutton)
                    .addComponent(absenoutbutton))
                .addGap(53, 53, 53)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        Lkoginadmin.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        Lkoginadmin.setForeground(new java.awt.Color(51, 51, 255));
        Lkoginadmin.setText("LOGIN ADMIN");

        Lusernameadmin.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lusernameadmin.setForeground(new java.awt.Color(51, 51, 255));
        Lusernameadmin.setText("USERNAME");

        Tusernameadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TusernameadminActionPerformed(evt);
            }
        });

        Lpasswordadmin.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lpasswordadmin.setForeground(new java.awt.Color(51, 51, 255));
        Lpasswordadmin.setText("PASSWORD");

        pwadminlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwadminloginActionPerformed(evt);
            }
        });

        Buttonloginadmin.setBackground(new java.awt.Color(255, 255, 255));
        Buttonloginadmin.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Buttonloginadmin.setForeground(new java.awt.Color(51, 51, 255));
        Buttonloginadmin.setText("LOGIN");
        Buttonloginadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonloginadminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lkoginadmin)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Buttonloginadmin)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lusernameadmin, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Lpasswordadmin))
                            .addGap(39, 39, 39)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Tusernameadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pwadminlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Lkoginadmin)
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lusernameadmin)
                    .addComponent(Tusernameadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lpasswordadmin)
                    .addComponent(pwadminlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(Buttonloginadmin)
                .addContainerGap(497, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        Lkoginadmin1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        Lkoginadmin1.setForeground(new java.awt.Color(51, 51, 255));
        Lkoginadmin1.setText("LOGIN ADMIN");

        Lusernameadmin1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lusernameadmin1.setForeground(new java.awt.Color(51, 51, 255));
        Lusernameadmin1.setText("USERNAME");

        Tusernameadmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tusernameadmin1ActionPerformed(evt);
            }
        });

        Lpasswordadmin1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lpasswordadmin1.setForeground(new java.awt.Color(51, 51, 255));
        Lpasswordadmin1.setText("PASSWORD");

        pwadminlogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwadminlogin1ActionPerformed(evt);
            }
        });

        Buttonloginadmin1.setBackground(new java.awt.Color(255, 255, 255));
        Buttonloginadmin1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Buttonloginadmin1.setForeground(new java.awt.Color(51, 51, 255));
        Buttonloginadmin1.setText("LOGIN");
        Buttonloginadmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buttonloginadmin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lkoginadmin1)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Buttonloginadmin1)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lusernameadmin1)
                                .addComponent(Lpasswordadmin1))
                            .addGap(39, 39, 39)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pwadminlogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Tusernameadmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Lkoginadmin1)
                .addGap(44, 44, 44)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lusernameadmin1)
                    .addComponent(Tusernameadmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lpasswordadmin1)
                    .addComponent(pwadminlogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(Buttonloginadmin1)
                .addContainerGap(497, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        Lkoginadmin2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        Lkoginadmin2.setForeground(new java.awt.Color(51, 51, 255));
        Lkoginadmin2.setText("ACCEPT IZIN");

        Lidkaryawanalasan1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lidkaryawanalasan1.setForeground(new java.awt.Color(51, 51, 255));
        Lidkaryawanalasan1.setText("ID KARYAWAN");

        Lalasan1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lalasan1.setForeground(new java.awt.Color(51, 51, 255));
        Lalasan1.setText("ALASAN");

        cbalasan1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cbalasan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "sakit", "cuti", "cuti melahirkan" }));
        cbalasan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbalasan1ActionPerformed(evt);
            }
        });

        Tidkaryawanzin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tidkaryawanzin1ActionPerformed(evt);
            }
        });

        Lmulaitanggal1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lmulaitanggal1.setForeground(new java.awt.Color(51, 51, 255));
        Lmulaitanggal1.setText("MULAI TANGGAL");

        Lhinggatanggal1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lhinggatanggal1.setForeground(new java.awt.Color(51, 51, 255));
        Lhinggatanggal1.setText("HINGGA TANGGAL");

        Tidtanggalmulai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tidtanggalmulai1ActionPerformed(evt);
            }
        });

        Tidtanggalhingga1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tidtanggalhingga1ActionPerformed(evt);
            }
        });

        Lalasan3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Lalasan3.setForeground(new java.awt.Color(51, 51, 255));
        Lalasan3.setText("DETAIL KETERANGAN");

        Tdetail1.setColumns(20);
        Tdetail1.setRows(5);
        jScrollPane6.setViewportView(Tdetail1);

        abseninbutton2.setBackground(new java.awt.Color(255, 255, 255));
        abseninbutton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        abseninbutton2.setForeground(new java.awt.Color(51, 51, 255));
        abseninbutton2.setText("ACCEPT");
        abseninbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abseninbutton2ActionPerformed(evt);
            }
        });

        Tabizin1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabizin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabizin1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Tabizin1);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(Lkoginadmin2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(abseninbutton2))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Lidkaryawanalasan1)
                                            .addComponent(Lalasan1))
                                        .addGap(55, 55, 55)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbalasan1, 0, 122, Short.MAX_VALUE)
                                            .addComponent(Tidkaryawanzin1)))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(Lmulaitanggal1)
                                        .addGap(32, 32, 32)
                                        .addComponent(Tidtanggalmulai1))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(Lhinggatanggal1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Tidtanggalhingga1)))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lalasan3)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(127, 127, 127))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Lkoginadmin2)
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lidkaryawanalasan1)
                    .addComponent(Tidkaryawanzin1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lalasan3))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lalasan1)
                            .addComponent(cbalasan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lmulaitanggal1)
                            .addComponent(Tidtanggalmulai1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lhinggatanggal1)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Tidtanggalhingga1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(abseninbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        jTabbedPane1.addTab("tab7", jPanel9);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 35, 790, 815));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:\
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ButtonloginadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonloginadminActionPerformed
        // TODO add your handling code here:
        try {

            Connection con = (Connection) koneksi.getConnections();

            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM admin admin WHERE username='"+Tusernameadmin.getText()+"' AND password='"+pwadminlogin.getText()+"'");

            if (rs.next()) {
                if(Tusernameadmin.getText().equals(rs.getString("username"))&& pwadminlogin.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Login successful");
                    jTabbedPane1.setSelectedIndex(1);
                    clearlogin();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Username or password wrong");
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_ButtonloginadminActionPerformed

    private void pwadminloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwadminloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwadminloginActionPerformed

    private void TusernameadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TusernameadminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TusernameadminActionPerformed

    private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentShown
        // TODO add your handling code here:
        Ttime.setEditable(false);
        Tdate.setEditable(false);
    }//GEN-LAST:event_jPanel5ComponentShown

    private void pwpinabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwpinabsenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwpinabsenActionPerformed

    private void TdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TdateActionPerformed

    private void TtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtimeActionPerformed

    private void absenoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absenoutbuttonActionPerformed
        // TODO add your handling code here:
        try {

            Connection con = (Connection) koneksi.getConnections();

            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM data_karyawan WHERE id_karyawan='"+Tidkaryawanabsen.getText()+"' AND pin='"+pwpinabsen.getText()+"'");

            if (rs.next()) {
                if(Tidkaryawanabsen.getText().equals(rs.getString("id_karyawan"))&& pwpinabsen.getText().equals(rs.getString("pin"))){

                    String idkaryawana = Tidkaryawanabsen.getText();
                    String time = Ttime.getText();
                    String date = Tdate.getText();

                    String sql = "INSERT INTO absen_keluar (id_karyawanq, timer, dater) VALUES (?,?,?)";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, idkaryawana);
                    ps.setString(2, time);
                    ps.setString(3, date);

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "absen berhasi");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Id karyawan or pin wrong");
            }

        } catch (Exception e) {
        }finally{
            loadabsenkeluar();
            clearloginabsen();
        }
    }//GEN-LAST:event_absenoutbuttonActionPerformed

    private void abseninbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abseninbuttonActionPerformed
        // TODO add your handling code here:
        try {

            Connection con = (Connection) koneksi.getConnections();

            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM data_karyawan WHERE id_karyawan='"+Tidkaryawanabsen.getText()+"' AND pin='"+pwpinabsen.getText()+"'");

            if (rs.next()) {
                if(Tidkaryawanabsen.getText().equals(rs.getString("id_karyawan"))&& pwpinabsen.getText().equals(rs.getString("pin"))){

                    String idkaryawana = Tidkaryawanabsen.getText();
                    String time = Ttime.getText();
                    String date = Tdate.getText();

                    String sql = "INSERT INTO absen_masuk (id_karyawana, time, date) VALUES (?,?,?)";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, idkaryawana);
                    ps.setString(2, time);
                    ps.setString(3, date);

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "absen berhasi");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Id karyawan or pin wrong");
            }

        } catch (Exception e) {
        }
        finally{
        loadabsenmsuk();
        clearloginabsen();
        }
    }//GEN-LAST:event_abseninbuttonActionPerformed

    private void TidkaryawanabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidkaryawanabsenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TidkaryawanabsenActionPerformed

    private void TidkaryawanzinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidkaryawanzinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TidkaryawanzinActionPerformed

    private void clearbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbutton1ActionPerformed
        // TODO add your handling code here:
        int question = JOptionPane.showConfirmDialog(null, "Do you want to edit this data?","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION)
        try {
            String idkaryawan = Tidkaryawan.getText();
            String pin = pwpindata.getText();

            Connection con = (Connection) koneksi.getConnections();

            String sql ="UPDATE data_karyawan SET pin = ? WHERE id_karyawan = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pin);
            ps.setString(2, idkaryawan);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "data successfully updated");
        } catch (Exception ex) {
            Logger.getLogger(absenkaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            loaddata();
            clear();
        }
    }//GEN-LAST:event_clearbutton1ActionPerformed

    private void pwpindataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwpindataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwpindataActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        // TODO add your handling code here:
        clear();
        loaddata();
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        // TODO add your handling code here:

        int question = JOptionPane.showConfirmDialog(null, "DO you want to delete this data?","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION)
        try {
            String sql = "DELETE FROM data_karyawan WHERE id_karyawan ='" + Tidkaryawan.getText() + "'";

            Connection con = (Connection) koneksi.getConnections();
            PreparedStatement pat = con.prepareStatement(sql);
            pat.execute();

            JOptionPane.showMessageDialog(null, "Data succesfully deleted");
        } catch (Exception e) {
        }
        finally{
            loaddata();
            clear();
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
        // TODO add your handling code here:

        int question = JOptionPane.showConfirmDialog(null, "Do you want to edit this data?","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION)
        try {
            String idkaryawan = Tidkaryawan.getText();
            String nama = Tnama.getText();
            String jabatan = cbjabatan.getSelectedItem().toString();
            String kelamin = cbkelamin.getSelectedItem().toString();
            String kontak = Tkontak.getText();
            //String pin = pwpindata.getText();

            Connection con = (Connection) koneksi.getConnections();

            String sql ="UPDATE data_karyawan SET nama = ?, jabatan = ?, jenis_kelamin = ?, kontak = ? WHERE id_karyawan = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, jabatan);
            ps.setString(3, kelamin);
            ps.setString(4, kontak);
            //ps.setString(5, pin);
            ps.setString(5, idkaryawan);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "data successfully updated");
        } catch (Exception ex) {
            Logger.getLogger(absenkaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            loaddata();
            clear();
        }
    }//GEN-LAST:event_editbuttonActionPerformed

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed

        int question = JOptionPane.showConfirmDialog(null, "Do you want to save this data?","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION)

        try {
            String idkaryawan = Tidkaryawan.getText();
            String nama = Tnama.getText();
            String jabatan = cbjabatan.getSelectedItem().toString();
            String kelamin = cbkelamin.getSelectedItem().toString();
            String kontak = Tkontak.getText();
            String pin = pwpindata.getText();

            Connection con = (Connection) koneksi.getConnections();

            String sql =  "INSERT INTO data_karyawan (id_karyawan, nama, jabatan, jenis_kelamin, kontak, pin) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idkaryawan);
            ps.setString(2, nama);
            ps.setString(3, jabatan);
            ps.setString(4, kelamin);
            ps.setString(5, kontak);
            ps.setString(6, pin);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "data successfully saved");

        } catch (Exception ex) {
            Logger.getLogger(absenkaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            loaddata();
            clear();
        }
    }//GEN-LAST:event_savebuttonActionPerformed

    private void cbkelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkelaminActionPerformed

    private void cbjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjabatanActionPerformed
        // TODO add your handling code here:
        String jabatan = cbjabatan.getSelectedItem().toString();
    }//GEN-LAST:event_cbjabatanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Tidkaryawan.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        Tnama.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        cbjabatan.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),2 ).toString());
        cbkelamin.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),3 ).toString());
        Tkontak.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        pwpindata.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void TkontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TkontakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TkontakActionPerformed

    private void TnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnamaActionPerformed

    private void TidkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidkaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TidkaryawanActionPerformed

    private void pwpinizinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwpinizinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwpinizinActionPerformed

    private void abseninbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abseninbutton1ActionPerformed
        // TODO add your handling code here:
        int question = JOptionPane.showConfirmDialog(null, "Do you want to submit this?","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION)
        
        try {

            Connection con = (Connection) koneksi.getConnections();

            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM data_karyawan WHERE id_karyawan='"+Tidkaryawanzin.getText()+"' AND pin='"+pwpinizin.getText()+"'");

            if (rs.next()) {
                if(Tidkaryawanzin.getText().equals(rs.getString("id_karyawan"))&& pwpinizin.getText().equals(rs.getString("pin"))){

                    String idkaryawan = Tidkaryawanzin.getText();
                    String alasan = cbalasan.getSelectedItem().toString();
                    String detail = Tdetail.getText();
                    String tmulai = Tidtanggalmulai.getText();
                    String thingga = Tidtanggalhingga.getText();
                    
                    String sql = "INSERT INTO izin (id_karyawan, alasan, detail, mulaitanggal, hinggatanggal) VALUES (?,?,?,?,?)";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, idkaryawan);
                    ps.setString(2, alasan);
                    ps.setString(3, detail);
                    ps.setString(4, tmulai);
                    ps.setString(5, thingga);

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Izin waiting for accepted");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Id karyawan or pin wrong");
            }

        } catch (Exception e) {
        } finally{
            loaddataizinacc();
            clearizin();
        }
    }//GEN-LAST:event_abseninbutton1ActionPerformed

    private void TidtanggalmulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidtanggalmulaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TidtanggalmulaiActionPerformed

    private void TidtanggalhinggaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidtanggalhinggaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TidtanggalhinggaActionPerformed

    private void Tusernameadmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tusernameadmin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tusernameadmin1ActionPerformed

    private void pwadminlogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwadminlogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwadminlogin1ActionPerformed

    private void Buttonloginadmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buttonloginadmin1ActionPerformed
        // TODO add your handling code here:
        try {

            Connection con = (Connection) koneksi.getConnections();

            Statement st = (Statement) koneksi.getConnections().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM admin admin WHERE username='"+Tusernameadmin1.getText()+"' AND password='"+pwadminlogin1.getText()+"'");

            if (rs.next()) {
                if(Tusernameadmin1.getText().equals(rs.getString("username"))&& pwadminlogin1.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Login successful");
                    jTabbedPane1.setSelectedIndex(6);
                    clearlogin();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Username or password wrong");
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_Buttonloginadmin1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Tidkaryawanzin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tidkaryawanzin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tidkaryawanzin1ActionPerformed

    private void Tidtanggalmulai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tidtanggalmulai1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tidtanggalmulai1ActionPerformed

    private void Tidtanggalhingga1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tidtanggalhingga1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tidtanggalhingga1ActionPerformed

    private void cbalasan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbalasan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbalasan1ActionPerformed

    private void abseninbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abseninbutton2ActionPerformed
        // TODO add your handling code here:
        int question = JOptionPane.showConfirmDialog(null, "Do you want to accept this?","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION)
        
        try {

            Connection con = (Connection) koneksi.getConnections();

            Statement st = (Statement) koneksi.getConnections().createStatement();

                    String idkaryawan = Tidkaryawanzin1.getText();
                    String alasan = cbalasan1.getSelectedItem().toString();
                    String detail = Tdetail1.getText();
                    String tmulai = Tidtanggalmulai1.getText();
                    String thingga = Tidtanggalhingga1.getText();
                    
                    String sql = "INSERT INTO accepted_izin (id_karyawan, alasan, detail, mulaitanggal, hinggatanggal) VALUES (?,?,?,?,?)";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, idkaryawan);
                    ps.setString(2, alasan);
                    ps.setString(3, detail);
                    ps.setString(4, tmulai);
                    ps.setString(5, thingga);

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Izin are accepted");
                
            

        } catch (Exception e) {
        } finally{
            loaddataizin();
            clearizinacc();
        }
    }//GEN-LAST:event_abseninbutton2ActionPerformed

    private void Tabizin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabizin1MouseClicked
        // TODO add your handling code here:
        Tidkaryawanzin1.setText(Tabizin1.getValueAt(Tabizin1.getSelectedRow(), 0).toString());
        cbalasan1.setSelectedItem(Tabizin1.getValueAt(Tabizin1.getSelectedRow(), 1).toString());
        Tdetail1.setText(Tabizin1.getValueAt(Tabizin1.getSelectedRow(), 2).toString());
        Tidtanggalmulai1.setText(Tabizin1.getValueAt(Tabizin1.getSelectedRow(), 3).toString());
        Tidtanggalhingga1.setText(Tabizin1.getValueAt(Tabizin1.getSelectedRow(), 4).toString());

    }//GEN-LAST:event_Tabizin1MouseClicked

    private void abseninbutton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abseninbutton3ActionPerformed
        // TODO add your handling code here:
        loaddataizinacc();
    }//GEN-LAST:event_abseninbutton3ActionPerformed

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
            java.util.logging.Logger.getLogger(absenkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(absenkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(absenkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(absenkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new absenkaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonloginadmin;
    private javax.swing.JButton Buttonloginadmin1;
    private javax.swing.JLabel Lalasan;
    private javax.swing.JLabel Lalasan1;
    private javax.swing.JLabel Lalasan2;
    private javax.swing.JLabel Lalasan3;
    private javax.swing.JLabel Ldate;
    private javax.swing.JLabel Lhinggatanggal;
    private javax.swing.JLabel Lhinggatanggal1;
    private javax.swing.JLabel Lidkaryawanabsen;
    private javax.swing.JLabel Lidkaryawanalasan;
    private javax.swing.JLabel Lidkaryawanalasan1;
    private javax.swing.JLabel Lkoginadmin;
    private javax.swing.JLabel Lkoginadmin1;
    private javax.swing.JLabel Lkoginadmin2;
    private javax.swing.JLabel Lmulaitanggal;
    private javax.swing.JLabel Lmulaitanggal1;
    private javax.swing.JLabel Lpasswordadmin;
    private javax.swing.JLabel Lpasswordadmin1;
    private javax.swing.JLabel Lpindata;
    private javax.swing.JLabel Ltime;
    private javax.swing.JLabel Lusernameadmin;
    private javax.swing.JLabel Lusernameadmin1;
    private javax.swing.JLabel PINizin;
    private javax.swing.JTable Tababsenkeluar;
    private javax.swing.JTable Tababsenmasuk;
    private javax.swing.JTable Tabizin;
    private javax.swing.JTable Tabizin1;
    private javax.swing.JTextField Tdate;
    private javax.swing.JTextArea Tdetail;
    private javax.swing.JTextArea Tdetail1;
    private javax.swing.JTextField Tidkaryawan;
    private javax.swing.JTextField Tidkaryawanabsen;
    private javax.swing.JTextField Tidkaryawanzin;
    private javax.swing.JTextField Tidkaryawanzin1;
    private javax.swing.JTextField Tidtanggalhingga;
    private javax.swing.JTextField Tidtanggalhingga1;
    private javax.swing.JTextField Tidtanggalmulai;
    private javax.swing.JTextField Tidtanggalmulai1;
    private javax.swing.JTextField Tkontak;
    private javax.swing.JTextField Tnama;
    private javax.swing.JLabel Tpinabsen;
    private javax.swing.JTextField Ttime;
    private javax.swing.JTextField Tusernameadmin;
    private javax.swing.JTextField Tusernameadmin1;
    private javax.swing.JButton abseninbutton;
    private javax.swing.JButton abseninbutton1;
    private javax.swing.JButton abseninbutton2;
    private javax.swing.JButton abseninbutton3;
    private javax.swing.JButton absenoutbutton;
    private javax.swing.JComboBox<String> cbalasan;
    private javax.swing.JComboBox<String> cbalasan1;
    private javax.swing.JComboBox<String> cbjabatan;
    private javax.swing.JComboBox<String> cbkelamin;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton clearbutton1;
    private javax.swing.JButton deletebutton;
    private javax.swing.JButton editbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabelabsen;
    private javax.swing.JPasswordField pwadminlogin;
    private javax.swing.JPasswordField pwadminlogin1;
    private javax.swing.JPasswordField pwpinabsen;
    private javax.swing.JPasswordField pwpindata;
    private javax.swing.JPasswordField pwpinizin;
    private javax.swing.JButton savebutton;
    // End of variables declaration//GEN-END:variables
}
