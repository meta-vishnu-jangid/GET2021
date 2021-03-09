package main;

/**
 * Class for Operations on infix Expresion like evaluation, conversion to Postfix
 * @author vishnu.jangid_metacu
 *
 */
public class InfixExpression {
	
	/**
     * this method is used to convert an infix expression to postfix expression
     * @param infixExpression String
     * @return postfixExpression String
     * @throws AssertionError if input is null
     */
    public static String infixToPostfix(String infixExpression) throws AssertionError {
        Stack<String> stack = new Stack<String>(100);
        
        if(infixExpression == null)
            throw new AssertionError("Invalid Input!");
        
        String[] expressionTokens = infixExpression.trim().split(" ");
        String postfixExpression = "";
        
        for(String token: expressionTokens) {
            if("(".equals(token)){
            	stack.push(token);
            }
            else if(")".equals(token)) {
                while(!("(".equals(stack.peek()))){
                	 postfixExpression += stack.pop() + " ";
                }
                stack.pop();
            }
            else if(isOperator(token)){
                if(stack.isEmpty() || "(".equals(stack.peek()) || getPrecedence(token) > getPrecedence(stack.peek())){
                    stack.push(token);}
                else{
                    while(!stack.isEmpty() && !("(".equals(stack.peek())) && getPrecedence(token) <= getPrecedence(stack.peek())){
                    	 postfixExpression += stack.pop() +" ";
                    }
                    stack.push(token);
                }
            }
            else{
                postfixExpression += token + " ";
            }
        }
        while(!stack.isEmpty()){
            postfixExpression += stack.pop() + " ";
        }
   
        return postfixExpression.trim();
    }
    
    
    /**
     * Method to check if the given token is an operator or not
     * @param token
     * @return boolean value
     */
    private static boolean isOperator(String token) {
        boolean isOperator = false;
        
        switch(token){
            case "+":
            case "-":
            case "*":
            case "/":
            case "==":
            case "!=":
            case "<":
            case ">":
            case "<=":
            case ">=":
            case "&&":
            case "||":
            case "!":   isOperator = true;
                        break;
            
            default : isOperator = false;   
        }
        return isOperator;
    }
    
    
    /**
     * Method to get the precedence of the given operator
     * @param operator
     * @return precedence of the operator
     */
    private static int getPrecedence(String operator){
        int precedence = 0;
        
        switch(operator){
            case "+": precedence = 5;
                      break;
                      
            case "-": precedence = 5;
                      break;
                      
            case "*": precedence = 6;
                      break;
                      
            case "/": precedence = 6;
                      break;
                      
            case "==":precedence = 3;
                      break;
                      
            case "!=":precedence = 3;
                      break;
                      
            case "<": precedence = 4;
                      break;
                      
            case ">": precedence = 4;
                      break;
                      
            case "<=":precedence = 4;
                      break;
                      
            case ">=":precedence = 4;
                      break;
                      
            case "&&":precedence = 2;
                      break;
                      
            case "||":precedence = 1;
                      break;
                      
            case "!": precedence = 7;
                
            	      break;
        }
        return precedence;
    }
    
    
    /**
     * Method to evaluate an infix Expression
     * @param infixExpression String
     * @return String, evaluated Result
     * @throws AssertionError if expression is null or if expression is invalid
     */
    public static String evaluateExpression(String infixExpression) throws AssertionError{
    	
    	String result;
    	
    	Stack<String> stack = new Stack<String>(100);
    	
    	if(infixExpression == null){
    		throw new AssertionError("Expression cannot be null");
    	}
    	
    	String postfixExpresion = InfixExpression.infixToPostfix(infixExpression);
    	
    	String[] expressionTokens = postfixExpresion.split(" ");
    	
    	for(String token: expressionTokens){
    		
            if(isInteger(token)){
                stack.push(token);
            }
            else {
                String operand2 = stack.pop() ;
              
                String  operand1 = null ;  
                if(!token.equals("!")){
                	operand1 = stack.pop();
                }
                
                if(operand1 != null && isDouble(operand1) && isDouble(operand2)){
                	Double operand1Double = Double.parseDouble(operand1);
                	Double operand2Double = Double.parseDouble(operand2);
                	 switch(token){
                         case "+": stack.push(Double.toString(operand1Double + operand2Double));
                                   break;
                                   
                         case "-": stack.push(Double.toString(operand1Double - operand2Double));
                                   break;
                         
                         case "*": stack.push(Double.toString(operand1Double * operand2Double));
                                   break;
                         
                         case "/": if(operand2Double == 0)
                                     throw new AssertionError("Divide by zero exception");
                                   stack.push(Double.toString(operand1Double / operand2Double));
                                   break;
                                   
                         case ">=" : stack.push(Boolean.toString(operand1Double >= operand2Double));
                         			 break;
                         case "<=" : stack.push(Boolean.toString(operand1Double <= operand2Double));
             			             break;
                         case "==" : stack.push(Boolean.toString(operand1Double == operand2Double));
             			             break;      

                         case ">" : stack.push(Boolean.toString(operand1Double > operand2Double));
	             			         break;  
	             			 
                         case "<" : stack.push(Boolean.toString(operand1Double < operand2Double));
	             			        break;      			             
                             
                         default : throw new AssertionError("Invalid expresion! ");
                     }
                }
                else if(operand1 != null && isBoolean(operand1) && isBoolean(operand2)){
                	boolean operand1Boolean = Boolean.parseBoolean(operand1);
                	boolean operand2Boolean = Boolean.parseBoolean(operand2);
                	switch(token){
                        case "==": stack.push(Boolean.toString(operand1Boolean == operand2Boolean));
                                  break;
                                  
                        case "!=": stack.push(Boolean.toString(operand1Boolean != operand2Boolean));
                                  break;
                        
                        case "&&": stack.push(Boolean.toString(operand1Boolean && operand2Boolean));
                        		   break;
                                  
                        case "||" : stack.push(Boolean.toString(operand1Boolean || operand2Boolean));
                        			 break; 			             
                            
                        default : throw new AssertionError("Invalid expresion!");
                    }
                }
                else if( isBoolean(operand2) ){
                	boolean operand1Boolean = Boolean.parseBoolean(operand2);
                	switch(token)
                    {
                        case "!": stack.push(Boolean.toString(!operand1Boolean ));
                                  break;		             
                            
                        default : throw new AssertionError("Invalid expresion! ");
                    }
                }
                else{
                	throw new AssertionError("Invalid expresion");
                }
                
               
            }                 
        }
    	result = stack.pop();
        
        if(stack.isEmpty())
            return result;
        else
            throw new AssertionError("Missing operator!");
    	
    }
    
    /**
     * Method to check if the given token is an integer or not
     * @param token String
     * @return boolean, true if it is integer otherwise false
     */
    private static boolean isInteger(String token){
        try{
            Integer.parseInt(token);
            return true;
        }
        catch(NumberFormatException exception){
            return false;
        }
    }
    
    /**
     * Method to check if the given token is an Double or not
     * @param token String
     * @return boolean, true if it is Double otherwise false
     */
    private static boolean isDouble(String token){
        try{
            Double.parseDouble(token);
            return true;
        }
        catch(NumberFormatException exception){
            return false;
        }
    }
    
    /**
     * Method to check if the given token is an Boolean or not
     * @param token String
     * @return boolean, true if it is Boolean otherwise false
     */
    private static boolean isBoolean(String token)
    {
        try{
            Boolean.parseBoolean(token);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
