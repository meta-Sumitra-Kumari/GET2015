trigger SendMailToLoanApplier on Loan__c (after update) {
List<Loan__c> loanList = new List<Loan__c>();
  for(Loan__c loan : Trigger.new) {
      if((loan.Status__c == 'Approved' || loan.Status__c == 'Rejected')) {
          loanList.add(loan);
          System.debug(loan.Status__c);
      }
  }
  if(loanList.size() > 0) {
      try{
          System.debug(loanList.size());
          Messaging.SingleEmailMessage email = new Messaging.SingleEmailMessage();
          for(Loan__c loan : loanList) {
              String[] toAddress = new List<String>() ;
              toAddress.add(loan.Applicant_Email__c);
       email.setSenderDisplayName(loan.Manager__c);  
              Id toId =  loan.Id;
              email.setToAddresses(toAddress);
              email.plainTextBody = 'Hii'+loan.Name+'Your Loan for '+loan.Amount__c+' is'+loan.Status__c;
              System.debug('email' + email);
              Messaging.SendEmail(New Messaging.SingleEmailMessage[] {email});
          }
      }catch(Exception e) {
          System.debug(e);
      }
     
  }  
}