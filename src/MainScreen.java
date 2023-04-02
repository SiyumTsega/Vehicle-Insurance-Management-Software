import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import Plan.AllRisks;
import Plan.AssistanceRisk;
import Plan.DriverRisk;
import Plan.ObligatoryRisk;
import Plan.VehicleRisk;
import Policy.Customer;
import Policy.Policy;
import Policy.Vehicle;

public class MainScreen extends JFrame{
	
	// Customization
	
	Font myFont = new Font("SansSerif", Font.BOLD, 20);
	Color myColor = Color.gray;
	
	//Panel 1 : Customer
	
	JTextField subFName;
	JTextField subLName;
	JTextField subCity;
	JTextField subPhone;
	
	// Pane2 2 : Vehicle
	
	JTextField model;
	JTextField manufacturer;
	JTextField plateNb;
	JTextField estimated;
	JRadioButton damageRadio1;
	JRadioButton damageRadio2;
	JRadioButton damageRadio3;
	JRadioButton damageRadio4;
	ButtonGroup G1;
	
	
	//Panel 3 : Plan
	
	JCheckBox obligatoryCHKBX;
	JCheckBox allRiskCHKBX;
	JCheckBox vDamageCHKBX;
	JCheckBox dDamageCHKBX;
	JCheckBox assisCHKBX;
	List<String> coveredRisksList = new ArrayList<>();
	List<Float> premiumRisksList = new ArrayList<>();
	List<Float> coverageRisksList = new ArrayList<>();
	List<Float> ceilingRiskList = new ArrayList<>();
	
	
	// Panel 4
	
	JRadioButton yearRadio;
	JRadioButton yearRadio2;
	JRadioButton yearRadio3;
	ButtonGroup G2;
	JLabel todayLBL;
	int validityYEAR = 0;
	SimpleDateFormat df;
	Date currentDate;
	
	//Panel 5
	
	JTextField searchTXT;
	
	// Panel 6
	
	JTextArea risksTXT;
	
	//Panel 7
	
	JTextArea policyTXT;
	
	//Panel 8
	
	JTextArea customerTXT;
	
	//Panel 9
	
	JLabel claimingTXT;
	JLabel claimingTXT2;
	JTextField claimingCustomerField;
	
	//Panel 10
	
	JLabel claimingCustomerNameLBL;
	JLabel claimStatusLBL2;
	JTextArea claimingCustomerRisksCoveredAREA;
	JLabel claimingCustomerValidDateLBL;
	boolean cond1;
	boolean cond2;
	boolean cond3;
	
	//Panel 11
	
	JTextArea settlementArea;
	float totalPremium = 0f;
	float totalCoverage = 0f;
	float totalCeiling = 0f;
	
	//Panel 12
	
	JTextArea settlementArea2;
	
	public MainScreen(){
		
		customizePanel1();
		customizePanel2();
		customizePanel3();
		customizePanel4();
		customizePanel5();
		customizePanel6();
		customizePanel7();
		customizePanel8();
		customizePanel9();
		customizePanel10();
		customizePanel11();
		customizePanel12();
		
		
		
	}
 
	private void customizePanel1() {
		
		JPanel p1 = new JPanel();
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Customer ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);
		
		p1.setBorder(titledBorder);
		
		JLabel fNameLbl = new JLabel("First Name");
		JLabel lNameLbl = new JLabel("Last Name");
		JLabel cityLbl = new JLabel("City");
		JLabel phoneLbl = new JLabel("Phone");
		
		subFName = new JTextField();    subFName.setOpaque(false);
		subLName = new JTextField();	subLName.setOpaque(false);
		subCity = new JTextField();		subCity.setOpaque(false);
		subPhone = new JTextField();	subPhone.setOpaque(false);
		
		p1.add(fNameLbl);
		p1.add(subFName);
		p1.add(lNameLbl);
		p1.add(subLName);
		p1.add(cityLbl);
		p1.add(subCity);
		p1.add(phoneLbl);
		p1.add(subPhone);
		
		p1.setBounds(15, 15, 300, 200);
		p1.setLayout(new GridLayout(4, 2));
		
		///Adding Panel to JFrame
		
		this.setLayout(null);
		this.add(p1);
	}
	
	private void customizePanel2() {
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Vehicle ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);
		
		JPanel p2 = new JPanel();
		p2.setBorder(titledBorder);
		
		//JLabels
		
		JLabel plateNbLbl = new JLabel("Plate Nb");
		JLabel modelLbl = new JLabel("Model Year");
		JLabel manufacturerLbl = new JLabel("Manufacturer");
		JLabel estimatedLbl = new JLabel("Estimated Value");
		JLabel spaceLbl = new JLabel(" ");
		JLabel damageLbl = new JLabel("Major Damage");
		
		
		//JtextFields
		
		plateNb = new JTextField();       plateNb.setOpaque(false);
		model = new JTextField();		  model.setOpaque(false);
		manufacturer = new JTextField();  manufacturer.setOpaque(false);
		estimated = new JTextField();	  estimated.setOpaque(false);
		
		//RadionButtons
		
		damageRadio1 = new JRadioButton("Motor");
		damageRadio2 = new JRadioButton("Wheels");
		damageRadio3 = new JRadioButton("Body");
		damageRadio4 = new JRadioButton("None");
		
		G1 = new ButtonGroup();
		G1.add(damageRadio1);
		G1.add(damageRadio2);
		G1.add(damageRadio3);
		G1.add(damageRadio4);
		
		///Adding components to panel2
		
		 p2.add(plateNbLbl);
		 p2.add(plateNb);
		 p2.add(modelLbl);
		 p2.add(plateNb);
		 p2.add(modelLbl);
		 p2.add(model);
		 p2.add(manufacturerLbl);
		 p2.add(manufacturer);
		 p2.add(estimatedLbl);
		 p2.add(estimated);
		 p2.add(spaceLbl);
		 p2.add(damageLbl);
		 p2.add(damageRadio1);
		 p2.add(damageRadio2);
		 p2.add(damageRadio3);
		 p2.add(damageRadio4);
		 
		 //Customize p2
		 
		 p2.setBounds(15, 250, 300, 500);
		 p2.setLayout(new GridLayout(14, 1));
 		 add(p2);
	}
	
	private void customizePanel3() {
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Plan ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);
		
		JPanel p3 = new JPanel();
		p3.setBorder(titledBorder);
		p3.setBounds(330, 15, 300, 200);
		p3.setLayout(new GridLayout(6, 1));
		
		JLabel packageLBL = new JLabel("Please select your plan: ");
		
		/// Check boxes
		
		obligatoryCHKBX = new JCheckBox("Obligatory");
		allRiskCHKBX = new JCheckBox("All Risk");
		vDamageCHKBX = new JCheckBox("Vehicle Damage");
		dDamageCHKBX = new JCheckBox("Driver Damage");
		assisCHKBX = new JCheckBox("Assistance");
		
		// Get all risk covered by plan
		
		GetRisksCoveredByPlan();
		
		/// Adding Components to p3
		
		p3.add(packageLBL);
		p3.add(obligatoryCHKBX);
		p3.add(allRiskCHKBX);
		p3.add(vDamageCHKBX);
		p3.add(dDamageCHKBX);
		p3.add(assisCHKBX);
		
		add(p3);
		
		
	}
	
	private void customizePanel4() {

		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Validity Period ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);
		
		JPanel p4 = new JPanel();
		p4.setBorder(titledBorder);
		p4.setBounds(330, 250, 300, 250);
		p4.setLayout(new GridLayout(6, 1));
		
		JLabel spacer2 = new JLabel();            spacer2.setOpaque(false);
		yearRadio = new JRadioButton("1 Year");     
		yearRadio2 = new JRadioButton("2 Year2");
		yearRadio3 = new JRadioButton("3 Years");
		 
		
		yearRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				validityYEAR = 1;
			}
			
		});
		
		yearRadio2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				validityYEAR = 2;
			}
			
		});
		
		yearRadio3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				validityYEAR = 3;
			}
			
		});
		
		///BUtton Group
		
		G2 = new ButtonGroup();
		G2.add(yearRadio);
		G2.add(yearRadio2);
		G2.add(yearRadio3);
		
		//Date and Time
		todayLBL = new JLabel();
		df = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		todayLBL.setText("Today: " + df.format(currentDate));
		todayLBL.setOpaque(false);
		
		Font font = todayLBL.getFont();
		float size = font.getSize();
		todayLBL.setFont(font.deriveFont(size));
		
		
		
		/// Adding All Components to panel4
		
		p4.add(spacer2);
		p4.add(spacer2);
		p4.add(todayLBL);
		p4.add(spacer2);
		p4.add(yearRadio);
		p4.add(yearRadio2);
		p4.add(yearRadio3);
		
		//Adding panel4 to JFrame
		add(p4);
		
		
	}

	private void customizePanel5() {
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Actions ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);
		
		JPanel p5 = new JPanel();
		p5.setBounds(330, 520, 300, 230);
		p5.setBorder(titledBorder); 
		p5.setLayout(new GridLayout(7, 1));
		
		JButton saveBTN = new JButton("Save Customer");
		JButton showBTN = new JButton("Show Plan Details");
		JButton loadBTN = new JButton("Load Customer");
		JButton newBTN = new JButton("New Customer");
		
		searchTXT = new JTextField("Enter Car Plate Nb");
		searchTXT.setOpaque(false);
		
		showBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Add the code to executed
				
				String str = "";
				for(int i = 0; i < coveredRisksList.size(); i++) {
					str += coverageRisksList.get(i) + "\n";
				}
				
				risksTXT.setText(str);
				
				try {
					policyTXT.setText(GetPolicyData().toString());
					DisplayPaymentsOfPolicy();
				} catch(ParseException parseException) {
					parseException.printStackTrace();
				}
			}
			
		});
		
		saveBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					SaveCustomerMapToDisk();
				}catch(ParseException parseException) {
					parseException.printStackTrace();
				}catch(IOException ioException) {
					ioException.printStackTrace();
				}catch(ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				}
			}
			
		});
		
		
		JLabel spacer3 = new JLabel(" ");
		spacer3.setOpaque(false);
		
		loadBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				SearchCustomerByMobileNB();
			}
			
		});
	
	    JLabel spacer4 = new JLabel(" ");
	    spacer4.setOpaque(false);
	    JLabel spacer5 = new JLabel(" ");
	    spacer5.setOpaque(false);
	    JLabel spacer6 = new JLabel(" ");
	    spacer6.setOpaque(false);
		
	    newBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				NewCustomer();
			}
	    	
	    });
	
	    
	    p5.add(spacer6);
	    p5.add(showBTN);
	    p5.add(saveBTN);
	    p5.add(newBTN);
	    p5.add(spacer5);
	    p5.add(searchTXT);
	    p5.add(loadBTN);
	    
	    add(p5);
	    
	    
	}
	
	private void customizePanel6() {
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Covered Risks ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);	
		
		JPanel p6 = new JPanel();
		p6.setBorder(titledBorder);
		p6.setBounds(645, 15, 300, 200);
		
		risksTXT = new JTextArea(7, 1);
		risksTXT.setEditable(false);
		risksTXT.setOpaque(false);
		risksTXT.setLineWrap(true);
		
		//Font
		
		Font font = risksTXT.getFont();
		float size = font.getSize2D() + 3.0f;
		risksTXT.setFont(font.deriveFont(size));
		
		p6.add(risksTXT);
		p6.setLayout(new GridLayout(1, 1));
		add(p6);   /// adding p6 to JFrame;
		
		
	}
	
	private void customizePanel7() {
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Policy Details ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);	
		
		JPanel p7 = new JPanel();
		p7.setBounds(645, 250, 300, 250);
		p7.setBorder(titledBorder);
//		p7.setLayout(new GridLayout(6, 1));
		
		policyTXT = new JTextArea(20, 1);
		policyTXT.setEditable(false);
		policyTXT.setOpaque(false);
		policyTXT.setLineWrap(true);
		
		Font font = policyTXT.getFont();
		float size = font.getSize() + 3.0f;
		policyTXT.setFont(font.deriveFont(size));
		
		p7.add(policyTXT);
		p7.setLayout(new GridLayout(1, 1));
		add(p7); // adding JPanel 7 to JFrame
	}

	private void customizePanel8() {
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Cutomer Details ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);	
		
		JPanel p8 = new JPanel();
		p8.setBorder(titledBorder);
		p8.setBounds(645, 520, 300, 230);
		p8.setLayout(new GridLayout(6, 1));
		
		customerTXT = new JTextArea(20, 1);
		customerTXT.setEditable(false);
		customerTXT.setOpaque(false);
		customerTXT.setLineWrap(true);
		
		/// increase the size of font 
		Font font = customerTXT.getFont();
		float size = font.getSize() + 3.0f;
		customerTXT.setFont(font.deriveFont(size));
		
		p8.add(customerTXT);
		p8.setLayout(new GridLayout(1, 1));
		add(p8);
	}
	
	private void customizePanel9() {
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Policy Details ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);	
		
		JPanel p9 = new JPanel();
		p9.setBorder(titledBorder);
		p9.setBounds(960, 15, 300, 485);
		
		claimingTXT = new JLabel("Enter Plate Nb for Claiming Customer");
		JLabel spacer99 = new JLabel("                                        ");
		claimingTXT2 = new JLabel("Select the type of damage of assistance needed");
	    
		claimingCustomerField = new JTextField();
		claimingCustomerField.setPreferredSize(new Dimension(250, 30));
		claimingCustomerField.setOpaque(false);
		
	    String[] items = {
	    		"Fire", "Robbery",
	    		"Third Party Damage",
	    		"Driver Damage",
	    		"Transport",
	    		"Car Replacement"
	    };
	    
	    final JList<String> claimList = new JList<>(items);
	    claimList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    
	    claimList.setOpaque(false);
	    claimList.setPreferredSize(new Dimension(250, 150));
	    
	    JButton searchClaimer = new JButton("Search Customer");
	    List<String> coveredRisksByUserLIST = new ArrayList<>();
	    
	    searchClaimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cond1 = false;   // Customer is registered before
				cond2 = false;   // Is the customer's policy cover the claimed risk
				cond3 = false;   // is the policy date valid
			
	    	
			try {
				coveredRisksByUserLIST.clear();
				Customer c = ClaimsSearchCustomerByMobileNb();
				claimingCustomerNameLBL.setText("Claimng Customer: "+c.getFname()+c.getLname());
				cond1 = true;
				
				String str7 = "";
				for(int i = 0; i < c.getPolicy().getRisksCoveredList().size(); i++) {
					str7 += c.getPolicy().getRisksCoveredList().get(i) + "\n";
					coveredRisksByUserLIST.add(c.getPolicy().getRisksCoveredList().get(i));
				}
				
				LocalDate v_validityofPolicy = c.getPolicy().getPolicyDate();
				int v_policyValidityYears = c.getPolicy().getValidityYear();
				v_validityofPolicy = v_validityofPolicy.plusYears(v_policyValidityYears);
				CheckPolicyValidity(v_validityofPolicy);
				
				claimingCustomerRisksCoveredAREA.setText("Covered Risks by Customer plan: \n" + str7);
				
				claimingCustomerValidDateLBL.setText("Date Validity of Policy: " + v_validityofPolicy+ " || "+CheckPolicyValidity(v_validityofPolicy));
				
				if(c.getPolicy().getRisksCoveredList().size() >= 5) {
					
					//if the user has a all-risks plan
					
					cond2 = true;
				}}catch(Exception re) {
					claimingCustomerNameLBL.setText("Claiming Customer: Not Found");
				}
				
			
			}
	    });
	
	    JButton confirmClaimBTN = new JButton("     Confirm Claim");
	    confirmClaimBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/// Get the index all selected items
				
				int[] selectedIx = claimList.getSelectedIndices();
				List<String> claimed_list = new ArrayList<>();
				
				if(claimList.getSelectedIndex() != -1) {
					for(int i = 0; i < selectedIx.length; i++) {
						String k = "" + claimList.getModel().getElementAt(selectedIx[i]) + " ";
						claimed_list.add(""+ claimList.getModel().getElementAt(selectedIx[i]));
						System.out.println("" + k);
					}
				}
				
				//Check for included risks
				
				if(cond2 == false) {
					cond2 = claimed_list.containsAll(coveredRisksByUserLIST);
				}
				
				
				//Check for claim validity to add the claim to the customer, claims map on the other file myfile
				
				ClaimIsValid();
				
				/// Display Settlements
				
				Customer c = ClaimsSearchCustomerByMobileNb();
				
				if(ClaimIsValid()) {
					int claims_nb = claimed_list.size();
					if(claimed_list.contains("Fire")) {
						settlementArea2.setText("Fire Department: " + c.getPolicy().getVehicle().getEstimatedValue()*0.25 + "  $");
						
					}else if(claimed_list.contains("Robbery")) {
						settlementArea2.setText("ProSec Company: " + c.getPolicy().getVehicle().getEstimatedValue()*0.5 + " " + 
					"Pay for the Customer " + c.getPolicy().getVehicle().getEstimatedValue()*1 + " $");
					}else if(claimed_list.contains("Third Party Damage")) {
						settlementArea2.setText("Driver in other car: " + 2000 + "$");
					}else if(claimed_list.contains("Vehicle Damage")) {
						settlementArea2.setText("Pay for Customer: " + 
					c.getPolicy().getVehicle().getEstimatedValue()*1+" $");
					}else if(claimed_list.contains("Transport")) {
						settlementArea2.setText("Transport Company " + 
					c.getPolicy().getVehicle().getEstimatedValue()*10+ " $");
					}else if(claimed_list.contains("Car Replacement")) {
						settlementArea2.setText("Car Rental Company " + 
					c.getPolicy().getVehicle().getEstimatedValue()*0.2+" $");
					}else if(claims_nb > 2) {
						settlementArea2.setText("Driver "
						+c.getPolicy().getVehicle().getEstimatedValue()*4+ " "+
								"Hospital " + c.getPolicy().getVehicle().getEstimatedValue()*4+ " $"+
						"Car Rental Company "+
						c.getPolicy().getVehicle().getEstimatedValue()*0.2+" $"+
						"Third Party Driver " + c.getPolicy().getVehicle().getEstimatedValue()*2);
					}else {
						
					}
				}
			} 
	    	
	    }); 
	    
	    p9.add(claimingTXT);
	    p9.add(claimingCustomerField);
	    p9.add(searchClaimer);
	    p9.add(spacer99);
	    p9.add(claimingTXT2);
	    p9.add(claimList);
	    p9.add(confirmClaimBTN);
	    add(p9);
	    
	    
	    
	}
	
	
	private void customizePanel10() {
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Claim Status ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);	
		
		JPanel p10 = new JPanel();
		p10.setBorder(titledBorder);
		p10.setBounds(960, 520, 300, 230);
		p10.setLayout(new GridLayout(4, 1));
		
		claimingCustomerNameLBL = new JLabel("Claiming Customer: ");
		claimingCustomerValidDateLBL = new JLabel("Date Validity of the Policy");
		claimStatusLBL2 = new JLabel("Claiming Status");
		
		claimingCustomerRisksCoveredAREA = new JTextArea();
		JScrollPane pictureScrollPane = new JScrollPane(claimingCustomerRisksCoveredAREA);
		claimingCustomerRisksCoveredAREA.setOpaque(false);
		
		p10.add(claimingCustomerNameLBL);
		p10.add(claimingCustomerValidDateLBL);
		p10.add(pictureScrollPane);
		p10.add(claimStatusLBL2);
		add(p10);
		
	}
	
	private void customizePanel11() {
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Payments ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);
		
		JPanel p11 = new JPanel();
		p11.setBorder(titledBorder);
		p11.setBounds(1275, 15, 250, 230);
		p11.setLayout(new GridLayout(2,1));
		
		
		settlementArea = new JTextArea();
		settlementArea.setOpaque(false);
		
		/// Increasing the size of JTextArea
		
		Font font = settlementArea.getFont();
		float size = font.getSize()  + 4.0f;
		settlementArea.setFont(font.deriveFont(size));
		
		p11.add(settlementArea);
		add(p11);
		
	}
	

	private void customizePanel12() {
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1),
				" Settlements ", TitledBorder.CENTER, 
				TitledBorder.DEFAULT_POSITION, 
				myFont, myColor);
		
		JPanel p12 = new JPanel();
		p12.setBorder(titledBorder);
		p12.setBounds(1275, 250, 250, 500);
		p12.setLayout(new GridLayout());
		
		settlementArea2 = new JTextArea();
		settlementArea2.setOpaque(false);
		p12.add(settlementArea2);
		
		Font font = settlementArea2.getFont();
		float size = font.getSize() + 3.0f;
		settlementArea2.setFont(font.deriveFont(size));
		
		add(p12);
	}

	/*********** Methods ***************/
	/***********************************/
	
	// Get Customer Data
	
	public Customer GetCustomerData() throws ParseException{
		
		Customer customer = new Customer(
				subFName.getText(),
				subLName.getText(),
				subCity.getText(),
				Integer.parseInt(subPhone.getText()),
				GetPolicyData()
				);
		
		return customer;
				
	}
	
	
	/// Vehicle Data
	
	public Vehicle GetVehicleData() throws ParseException{
		
		Vehicle vehicle = new Vehicle(
				
				Integer.parseInt(plateNb.getText()),
				Integer.parseInt(model.getText()),
				manufacturer.getText(),
				Integer.parseInt(estimated.getText()),
				GetDamageState()
				
				);

	return vehicle;
	}

	// Get Policy Data
	
	public Policy GetPolicyData() throws ParseException{
		currentDate = new Date();
		LocalDate now = LocalDate.now();
		
		Policy policy = new Policy(
				
				GetVehicleData(),
				coveredRisksList,
				premiumRisksList,
				coverageRisksList,
				ceilingRiskList,
				validityYEAR,
				now);
				
		return policy;
	}
	
	/// Get Damage Data
		public int  GetDamageState() {
			
			if(damageRadio1.isSelected()) {
				return 1;
			}else if(damageRadio2.isSelected()) {
				return 2;
			}else if(damageRadio3.isSelected()) {
				return 1;
			}else
			return 0;
		}
	
	/// Gate plan details
		
	public void GetRisksCoveredByPlan() {
		
		AllRisks allRisk = new AllRisks();
		allRiskCHKBX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dDamageCHKBX.setEnabled(false);
				vDamageCHKBX.setEnabled(false);
				assisCHKBX.setEnabled(false);
				obligatoryCHKBX.setEnabled(false);
				
				///Adding risk details to an array
				
				for(int i = 0; i < allRisk.allRisksCovered.length; i++) {
					coveredRisksList.add(allRisk.allRisksCovered[i]);
				}
				
				premiumRisksList.add(allRisk.getPremium());
				coverageRisksList.add(allRisk.getCoverage());
				ceilingRiskList.add(allRisk.getCeiling());
				
			}
		});
		
		ObligatoryRisk obligatoryRisk = new ObligatoryRisk();
		obligatoryCHKBX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				///Adding Risks Detail to an array
				
				coveredRisksList.add(obligatoryRisk.obligatoryRisksCovered[0]);
				premiumRisksList.add(obligatoryRisk.getPremium());
				coverageRisksList.add(obligatoryRisk.getCoverage());
				ceilingRiskList.add(obligatoryRisk.getCeiling());
			}
		});
		
		vDamageCHKBX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VehicleRisk vehicleRisk = new VehicleRisk();
				
				///Adding Risk Details to arrays
				
				coveredRisksList.add(vehicleRisk.vehicleRisksCovered[0]);
				premiumRisksList.add(vehicleRisk.getPremium());
				coverageRisksList.add(vehicleRisk.getCoverage());
				ceilingRiskList.add(vehicleRisk.getCeiling());
			}
		});
		
		dDamageCHKBX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DriverRisk driverRisk = new DriverRisk();
				coveredRisksList.add(driverRisk.driverRisksCovered[0]);
				premiumRisksList.add(driverRisk.getPremium());
				coverageRisksList.add(driverRisk.getCoverage());
				ceilingRiskList.add(driverRisk.getCeiling());
				
			}
		});
		
		
		assisCHKBX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				AssistanceRisk assistanceRisk = new AssistanceRisk();
				
				//Adding Risk details to an array
				
				for(int i = 0; i < assistanceRisk.assistanceRisksCovered.length; i++) {
					coveredRisksList.add(assistanceRisk.assistanceRisksCovered[i]);
				}
				
				premiumRisksList.add(assistanceRisk.getPremium());
				coverageRisksList.add(assistanceRisk.getCoverage());
				ceilingRiskList.add (assistanceRisk.getCeiling());
			}
		});
		
	}

	//Save Data to disk
	
	public void SaveCustomerMapToDisk() throws IOException, ClassNotFoundException, ParseException {
		
		File file = new File("C:/myfile.dat");
		int platenmbr = Integer.parseInt(plateNb.getText());
		
		if(!file.exists()) {
			//Creating new file
			System.out.println("Not Existed");
			file.createNewFile();
			
			SaveCustomerMaptoNewFile(platenmbr, file);
		}else {
			///File exist
			
			TreeMap<Integer, Customer> newMapToSave = new TreeMap<>();
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>)ois.readObject();
			ois.close();
			is.close();
			
			
			/// Get old map
			
			for(Map.Entry<Integer, Customer> m : mapInFile.entrySet()){
			
				newMapToSave.put(m.getKey(), m.getValue());
			}
			
			//Updating the map : adding new customer to map
			
			newMapToSave.put(platenmbr, GetCustomerData());
			
			//Saving the update to the file
			
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(newMapToSave);
			oos.flush();
			oos.close(); 
			
		}
	}
	
	
	private void SaveCustomerMaptoNewFile(int platenmbr, File file) throws ParseException, IOException {
		
		TreeMap<Integer, Customer> newMaptoSave = new TreeMap<>();
		
		//Adding new Customer to map
		
		newMaptoSave.put(platenmbr, GetCustomerData());
		
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(newMaptoSave);
		oos.flush();
		oos.close();
	}


	/// Resetting Fields to empty
	
	private void NewCustomer() {
		
		coveredRisksList.clear();
		coverageRisksList.clear();
		premiumRisksList.clear();
		ceilingRiskList.clear();
		cond1 = false;
		cond2 = false;
		cond3 = true;
		
		// Set text fields to empty
		
		subFName.setText("");
		subLName.setText("");
		subCity.setText("");
		subPhone.setText("");
		plateNb.setText("");
		model.setText("");
		manufacturer.setText("");
		estimated.setText("");
		
		
		/// Set the radion button selection to non
		
		G1.clearSelection();
		G2.clearSelection();
		
		/// Reset the check boxes
		
		obligatoryCHKBX.setSelected(false);
		allRiskCHKBX.setSelected(false);
		vDamageCHKBX.setSelected(false);
		dDamageCHKBX.setSelected(false);
		assisCHKBX.setSelected(false);
		
		obligatoryCHKBX.setEnabled(true);
		vDamageCHKBX.setEnabled(true);
		dDamageCHKBX.setEnabled(true);
		assisCHKBX.setEnabled(true);
		
		
		
	}


	private void SearchCustomerByMobileNB() {
		File file = new File("C:/myfile.data");
		
		try {
			
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>)ois.readObject();
			ois.close();
			is.close();
			
			Customer c_finded = mapInFile.get(Integer.parseInt(searchTXT.getText()));
			customerTXT.setText(c_finded.toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
		private Customer ClaimsSearchCustomerByMobileNb() throws ParseException{
			
			Customer customer = new Customer(
					subFName.getText(),
					subLName.getText(),
					subCity.getText(),
					Integer.parseInt(subPhone.getText()),
					GetPolicyData()
					);
			
			File file = new File("C:/myfile.dat");
			
			try {
				InputStream is = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(is);
				
				TreeMap<Integer, Customer> mapInFile = (TreeMap <Integer, Customer>)ois.readObject();
				ois.close();
				is.close();
				
				customer = mapInFile.get(Integer.parseInt(claimingCustomerField.getText()));
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return customer;
			}
	
	private boolean CheckPolicyValidity(LocalDate v_validityOfPolicy) {
		
		LocalDate now = LocalDate.now();
		if(now.isBefore(v_validityOfPolicy)) {
			cond3 = true;
			return true;
		}else {
			cond3 = false;
			return false;
		}
	}
		
	private boolean ClaimIsValid() {
		if(cond1 == true && cond2 == true && cond3 == true) {
			claimStatusLBL2.setText("Claiming Status: You can register the claim");
			return true;
		}else {
			claimStatusLBL2.setText("Claiming Status: Not able to register the claim");
			return false;
		}
	}
	
	private void DisplayPaymentsOfPolicy() {
		for(int i = 0; i < premiumRisksList.size(); i++) {
			totalPremium += premiumRisksList.get(i);
			totalCoverage += coverageRisksList.get(i);
			totalCeiling += ceilingRiskList.get(i);
		}
		
		settlementArea.setText(
				
				"Total Premium: "+ totalPremium*Integer.parseInt(estimated.getText()) + " $ \n" +
			    "Risks Coverage: " + totalCoverage*Integer.parseInt(estimated.getText())* 10 + " $ \n" +
			    "Max Ceiling: " + totalCeiling*Integer.parseInt(estimated.getText()) + 10000 +" $ \n"
				);
	

}

public static void main(String[] args) {
		
		MainScreen mainScreen = new MainScreen();
		mainScreen.setVisible(true);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setTitle("Insurance Company System");
		mainScreen.setBounds(0, 0, 192, 1080);
	}
}
