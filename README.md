# PromotionalService
Java Code for SKU Service, where user can provide SKU data and Promotion Data and get the resultant total out

# Index.java
  This is the handler file, only running this file would fetch the result.
  no values are required to be passed to this call, the program would prompt for user entry
  required choice can be made on the same.

# Files <Please configure the file locations if required becoz of difference in Enviornments>
  This folder consists of the Promotion data in text format and the SKU data in text format
  the SKU data can also be given on the running stage so that the user has full privilage of the system.

# Handlers
  These are set of files which handles multiple separate operation of indivisual Elements
  These operations are specific to itself and loosely coupled

# Data
  This is the getter and setter for SKU data as that one of the basic data required for the complete process.

# Example Run
  ## Executing the code at level of C:\\>
  ## complete project path for index.java C:\PromotionalService\index.java
  When the index.java file is complied and executed, here are the expected way the program should react.
    
  Welcome to Promotion service.
  Do you want to use the preDefined SKU Data from PromotionalService//files//skuData.txt (Y/N/Q)
  ## choice to user to enter either y or n or q
  Y
  Using Data = A=30, B=40, C=50,D=40,SKU = 50  
  ## Promotional Data can be updated in file.promotion below showed data is the compiled version of the promotion
  Using Promotional Data as -
  {[A, A, A]=130, [B, B]=45, [C, D]=30, [SKU]=48}
  Enter the Buying Data in format A,A,A,B,B,B etc  
  ## User to enter the items brought, the items should match the SKU items or the items would be rejected
  
  SKU,SKU,SKU,A,B,C,Z,AA,CC,A,A,B,B,D

  Invalid Item, Z Item Not Present in the SKU. Ignoring the Item
  Invalid Item, AA Item Not Present in the SKU. Ignoring the Item
  Invalid Item, CC Item Not Present in the SKU. Ignoring the Item
  
  Adding 130 for [A, A, A]
  Adding 45 for [B, B]
  Adding 30 for [C, D]
  Adding 48 for SKU
  Adding 48 for SKU
  Adding 48 for SKU
  Adding 40 for B

  ==============================================================
  
  Cost to be charged = 389

# The test cases was not able to be designed as the configuration of the Junit was failing on the system.