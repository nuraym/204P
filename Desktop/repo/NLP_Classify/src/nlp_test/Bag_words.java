package nlp_test;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bag_words {
	
	   private static Set<String> ca_bag = new HashSet<String>();
	    private static Set<String> nga_bag = new HashSet<String>();
	    private static Set<String> sec_bag = new HashSet<String>();
	    private static Set<String> net_bag = new HashSet<String>();
	    private static Set<String> empl_bag = new HashSet<String>();
	    private static Set<String> elec_bag = new HashSet<String>();
	    private static Set<String> spp_bag = new HashSet<String>();
	    private static Set<String> lnd_bag = new HashSet<String>();
	    private static Set<String> trn_bag = new HashSet<String>(); //TRANSACTION
	    private static Set<String> tprt_bag = new HashSet<String>(); //TRANSPORT
	    private static Set<String> amd_bag = new HashSet<String>();
	    private static Set<String> trs_bag = new HashSet<String>();
	    private static Set<String> mrg_bag = new HashSet<String>();
	    private static Set<String> fee_bag = new HashSet<String>();
	    private static Set<String> lnk_bag = new HashSet<String>();
	    private static Set<String> opr_bag = new HashSet<String>();
	    private static Set<String> prc_bag = new HashSet<String>();
	    private static Set<String> trd_bag = new HashSet<String>();


		private static Map<String, Integer> frequency_ca = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_nga = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_sec = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_net = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_empl = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_elec = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_spp = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_lnd = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_trn = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_tprt = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_amd = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_trs = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_mrg = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_fee = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_lnk = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_opr = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_prc = new HashMap<String, Integer>(); 
		private static Map<String, Integer> frequency_trd = new HashMap<String, Integer>(); 

		
		static void bagWords(){
			ca_bag.add("information");
			ca_bag.add("confidential");
			ca_bag.add("recipient");
			ca_bag.add("discloser");
			
			nga_bag.add("customer");
			nga_bag.add("marketer");
			nga_bag.add("gas");
			nga_bag.add("price");
			nga_bag.add("delivery");
			
			sec_bag.add("party");
			sec_bag.add("master");
			
			net_bag.add("netting");
			net_bag.add("obligation");
			
			empl_bag.add("employment agreement");
			empl_bag.add("base salary");
			empl_bag.add("vesting schedule");
			
			elec_bag.add("internet");
			elec_bag.add("computer equipment");
			elec_bag.add("internet connectivity");
			
			spp_bag.add("fuel");
			
			lnd_bag.add("exhibit");
			lnd_bag.add("parking");
			lnd_bag.add("lending");
			
			trn_bag.add("transition");
			
			tprt_bag.add("transporter");
			tprt_bag.add("imbalance");
			tprt_bag.add("operational");
			tprt_bag.add("operational imbalance");

			amd_bag.add("amend");
			amd_bag.add("amended");
			amd_bag.add("amendment");
			
			trs_bag.add("trust");
			trs_bag.add("trustee");
			trs_bag.add("trust agreement");
			
			mrg_bag.add("margin");
			
			fee_bag.add("fee agreement");
			fee_bag.add("access website");
			fee_bag.add("initial password");

			lnk_bag.add("web site");
			lnk_bag.add("login page");
			
			opr_bag.add("operating agreement");
			opr_bag.add("interconnect");
			
			prc_bag.add("delivery point");
			prc_bag.add("contract price");
			prc_bag.add("purchase price");
			
			trd_bag.add("website");
			trd_bag.add("terms conditions");
			trd_bag.add("through website");


		
		}
		
		static Integer calculateFreq(String anytext, String anyString){
			
			 String[] splitter = anytext.split("(?<=[,.])|(?=[,.])|\\s+");
			    int counter = 0;
			    for (String str : splitter)
			    {
			        if (str.equals(anyString))
			        {   
			            counter++;
			        }   
			    }
			    return counter;	
		}
		
		static Map<String, Integer> matchFreq_ca(String text){
			for(String word : ca_bag){
				int freq = calculateFreq(text, word);
				frequency_ca.put(word, freq);
				}
			return frequency_ca; 
		}
		static Map<String, Integer> matchFreq_nga(String text){
			for(String word : nga_bag){
				int freq = calculateFreq(text, word);
				frequency_nga.put(word, freq);
				}
			return frequency_nga; 
		}
		static Map<String, Integer> matchFreq_sec(String text){
			for(String word : sec_bag){
				int freq = calculateFreq(text, word);
				frequency_sec.put(word, freq);
				}
			return frequency_sec; 
		}
		static Map<String, Integer> matchFreq_net(String text){
			for(String word : net_bag){
				int freq = calculateFreq(text, word);
				frequency_net.put(word, freq);
				}
			return frequency_net; 
		}
		static Map<String, Integer> matchFreq_empl(String text){
			for(String word : empl_bag){
				int freq = calculateFreq(text, word);
				frequency_empl.put(word, freq);
				}
			return frequency_empl; 
		}
		static Map<String, Integer> matchFreq_elec(String text){
			for(String word : elec_bag){
				int freq = calculateFreq(text, word);
				frequency_elec.put(word, freq);
				}
			return frequency_elec; 
		}
		static Map<String, Integer> matchFreq_spp(String text){
			for(String word : spp_bag){
				int freq = calculateFreq(text, word);
				frequency_spp.put(word, freq);
				}
			return frequency_spp; 
		}
		static Map<String, Integer> matchFreq_lnd(String text){
			for(String word : lnd_bag){
				int freq = calculateFreq(text, word);
				frequency_lnd.put(word, freq);
				}
			return frequency_lnd; 
		}
		static Map<String, Integer> matchFreq_trn(String text){
			for(String word : trn_bag){
				int freq = calculateFreq(text, word);
				frequency_trn.put(word, freq);
				}
			return frequency_trn; 
		}
		static Map<String, Integer> matchFreq_tprt(String text){
			for(String word : tprt_bag){
				int freq = calculateFreq(text, word);
				frequency_tprt.put(word, freq);
				}
			return frequency_tprt; 
		}
		static Map<String, Integer> matchFreq_amd(String text){
			for(String word : amd_bag){
				int freq = calculateFreq(text, word);
				frequency_amd.put(word, freq);
				}
			return frequency_amd; 
		}
		static Map<String, Integer> matchFreq_trs(String text){
			for(String word : trs_bag){
				int freq = calculateFreq(text, word);
				frequency_trs.put(word, freq);
				}
			return frequency_trs; 
		}
		static Map<String, Integer> matchFreq_mrg(String text){
			for(String word : mrg_bag){
				int freq = calculateFreq(text, word);
				frequency_mrg.put(word, freq);
				}
			return frequency_mrg; 
		}
		static Map<String, Integer> matchFreq_fee(String text){
			for(String word : fee_bag){
				int freq = calculateFreq(text, word);
				frequency_fee.put(word, freq);
				}
			return frequency_fee; 
		}
		static Map<String, Integer> matchFreq_lnk(String text){
			for(String word : lnk_bag){
				int freq = calculateFreq(text, word);
				frequency_lnk.put(word, freq);
				}
			return frequency_lnk; 
		}
		static Map<String, Integer> matchFreq_opr(String text){
			for(String word : opr_bag){
				int freq = calculateFreq(text, word);
				frequency_opr.put(word, freq);
				}
			return frequency_opr; 
		}
		static Map<String, Integer> matchFreq_prc(String text){
			for(String word : prc_bag){
				int freq = calculateFreq(text, word);
				frequency_prc.put(word, freq);
				}
			return frequency_prc; 
		}
		static Map<String, Integer> matchFreq_trd(String text){
			for(String word : trd_bag){
				int freq = calculateFreq(text, word);
				frequency_trd.put(word, freq);
				}
			return frequency_trd; 
		}
		
	
		
		 static boolean scanFor_ca(String text){
			 matchFreq_ca(text);
			 if(frequency_ca.get("information") > 30 || frequency_ca.get("confidential") > 25
					 || frequency_ca.get("recipient") > 20 || frequency_ca.get("discloser") > 15){
				 return true;
				  }
			 return false;
			 
	 }
		static boolean scanFor_nga(String text){
			 matchFreq_nga(text);
			 if(frequency_nga.get("customer") > 22 || frequency_nga.get("marketer") > 28
					 || frequency_nga.get("gas") > 25 || frequency_nga.get("price") > 7 
					 || frequency_nga.get("delivery") > 10){
				 return true;
				  }
			return false;
			
			 }
		static boolean scanFor_sec(String text){
			matchFreq_sec(text);
			if(frequency_sec.get("party") > 90 || frequency_sec.get("master") > 50){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_net(String text){
			matchFreq_net(text);
			if(frequency_net.get("netting") > 25 || frequency_net.get("obligation") > 10){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_empl(String text){
			matchFreq_empl(text);
			if(frequency_empl.get("employment agreement") > 1 || frequency_empl.get("base salary") > 1 ||
					frequency_empl.get("vesting schedule") > 1){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_elec(String text){
			matchFreq_elec(text);
			if(frequency_elec.get("internet") > 5 || frequency_elec.get("computer equipment") > 5 ||
					frequency_elec.get("internet connectivity") > 2){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_spp(String text){
			matchFreq_spp(text);
			if(frequency_spp.get("fuel") > 5 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_lnd(String text){
			matchFreq_lnd(text);
			if(frequency_lnd.get("lending") > 10 || frequency_lnd.get("parking") > 10 ||
					frequency_lnd.get("exhibit") > 50){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_trn(String text){
			matchFreq_trn(text);
			if(frequency_trn.get("transition") > 10 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_tprt(String text){
			matchFreq_tprt(text);
			if(frequency_tprt.get("operational imbalance") > 10 || frequency_tprt.get("transporter") > 15 ||
					frequency_tprt.get("imbalance") > 20 || frequency_tprt.get("operational") > 20  ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_amd(String text){
			matchFreq_amd(text);
			if(frequency_amd.get("amend") > 10 || frequency_amd.get("amended") > 10 ||
					frequency_amd.get("amendment") > 10 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_trs(String text){
			matchFreq_trs(text);
			if(frequency_trs.get("trust") > 40 || frequency_trs.get("trustee") > 40 ||
					frequency_trs.get("trust agreement") > 20 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_mrg(String text){
			matchFreq_mrg(text);
			if(frequency_mrg.get("margin") > 15 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_fee(String text){
			matchFreq_fee(text);
			if(frequency_fee.get("fee agreement") > 5 ||
					frequency_fee.get("access website") > 3 || frequency_fee.get("initial password") > 3 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_lnk(String text){
			matchFreq_lnk(text);
			if(frequency_lnk.get("web site") > 10 ||
					frequency_lnk.get("login page") > 3 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_opr(String text){
			matchFreq_opr(text);
			if(frequency_opr.get("interconnect") > 10 ||
					frequency_opr.get("operating agreement") > 3 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_prc(String text){
			matchFreq_prc(text);
			if(frequency_prc.get("purchase price") > 10 ||
					frequency_prc.get("contract price") > 10 || frequency_prc.get("delivery point") > 5 ){
				 return true;
				  }
			return false;
			}
		static boolean scanFor_trd(String text){
			matchFreq_trd(text);
			if(frequency_trd.get("through website") > 5 ||
					frequency_prc.get("terms conditions") > 5 || frequency_prc.get("website") > 30 ){
				 return true;
				  }
			return false;
			}
		
		
		
		 static String decide(String text) {
			 if(scanFor_ca(text)) {
				 System.out.println("Frequency of CA" + " " + matchFreq_ca(text));
				return "CONFIDENTIALITY";
			 }
			 else if(scanFor_nga(text)){
				System.out.println("Frequency of Natural gas sales" + " " + matchFreq_nga(text));
				 return "Natural gas sales agreement";
				 
			 }
			 else if (scanFor_sec(text)) {
				System.out.println("Frequency of sec" + " " + matchFreq_sec(text));
				return "SECURITY"; 
			 }
			 else if (scanFor_net(text)) {
				System.out.println("Frequency of net" + " " + matchFreq_net(text));
				 return "NETTING"; 
			 }
			 else if (scanFor_empl(text)) {
				System.out.println("Frequency of Emp" + " " + matchFreq_empl(text));
				return "EMPLOYMENT"; 
			 }
			 else if (scanFor_elec(text)) {
				 System.out.println("Frequency of Elec" + " " + matchFreq_elec(text));
				 return "ELECTION"; 
			 }
			 else if (scanFor_spp(text)) {
				 System.out.println("Frequency of Spp" + " " + matchFreq_spp(text));
				 return "SUPPLY"; 
			 }
			 else if (scanFor_lnd(text)) {
				 System.out.println("Frequency of Lending" + " " + matchFreq_lnd(text));
				 return "LENDING"; 
			 }
			 else if (scanFor_trn(text)) {
				 System.out.println("Frequency of Transaction" + " " + matchFreq_trn(text));
				return "TRANSACTION"; 
			 }
			 else if (scanFor_tprt(text)) {
				 System.out.println("Frequency of Transport" + " " + matchFreq_tprt(text));
				 return "TRANSPORTATION"; 
			 }
			 else if (scanFor_amd(text)) {
				 System.out.println("Frequency of Amendment" + " " + matchFreq_amd(text));
				 return "AMENDMENT"; 
			 }
			 else if (scanFor_trs(text)) {
				 System.out.println("Frequency of Trust" + " " + matchFreq_trs(text));
				 return "TRUST"; 
			 }
			 else if (scanFor_mrg(text)) {
				System.out.println("Frequency of Margin" + " " + matchFreq_mrg(text));
				 return "MARGIN"; 
			 }
			 else if (scanFor_fee(text)) {
				System.out.println("Frequency of Fee" + " " + matchFreq_fee(text));
				 return "FEE"; 
			 }
			 else if (scanFor_lnk(text)) {
				System.out.println("Frequency of Link" + " " + matchFreq_lnk(text));
				 return "LINKING"; 
			 }
			 else if (scanFor_opr(text)) {
				System.out.println("Frequency of Operation" + " " + matchFreq_opr(text));
				 return "OPERATING"; 
			 }
			 else if (scanFor_prc(text)) {
				System.out.println("Frequency of Purchase" + " " + matchFreq_prc(text));
				 return "PURCHASE"; 
			 }
			 else if (scanFor_trd(text)) {
				System.out.println("Frequency of Trading" + " " + matchFreq_trd(text));
				 return "TRADING"; 
			 }
			
				 return "something else";
			 
		 }
		 
		 
		public static void main(String[] args) throws IOException{
		    
			String text =
			new String(Files.readAllBytes(Paths.get("/Users/nuraymuzaffarova/Desktop/Packaged/Agreements/TXT/3.58887.F1QTAYTZTS3SJB420ETPDM00PI0NUDMSB.1.txt")));
			text = text.toLowerCase();
			//System.out.println(text);
			//Integer count = calculateFreq(text, "confidential"); 
			//System.out.println(count);
			bagWords();
			//System.out.println("Frequency of CA" + " " + matchFreq_ca(text));
			
		
			
			System.out.println(decide(text)); 
				
		}
	}

