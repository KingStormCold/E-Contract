//package vn.easycredit.service.impl;
//
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//
//import lombok.extern.slf4j.Slf4j;
//import vn.easycredit.domain.Email;
//import vn.easycredit.domain.EmailAddress;
//import vn.easycredit.domain.ExceptionHandlerMonitoring;
//import vn.easycredit.domain.Utilities;
//import vn.easycredit.repository.ExceptionHandlerMonitoringRepository;
//import vn.easycredit.service.IEmailService;
//
//@Service
//@Slf4j
//@RefreshScope
//public class EmailServiceImpl implements IEmailService {
//	
//	@Autowired
//	private JavaMailSender emailSender;
//	
//	@Autowired
//	private SpringTemplateEngine templateEngine;
//	
//	@Value("#{'${exception_email.tos}'.split(',')}")
//	public List<String> emailTos;
//	
//	@Value("${exception_email.from}")
//	public String emailFrom;
//	
//	@Value("${exception_email.subject}")
//	public String subject;
//	
//	@Autowired
//	ExceptionHandlerMonitoringRepository exceptionHandlerMonitoringRepository;
//	
//	@Override
//	@Async("asyncExecutor")
//	public void sendEmail(Object object) {
//		// TODO Auto-generated method stub
//		try {
//			Email email = null;
//			MimeMessagePreparator preparator = null;
//			
//			if(object instanceof Email) {
//				email = (Email) object;
//			}else {
//				email = this.defaultSetEmail();
//			}
//			
//			preparator = getMessagePreparator(email);
//			emailSender.send(preparator);
//			log.info("Send email successed!");
//		} catch (Exception e) {
//			log.info("Send email failed: " + e.toString(), e);
//		}
//	}
//
//	private MimeMessagePreparator getMessagePreparator(Email mail) {
//	   
//        MimeMessagePreparator preparator = new MimeMessagePreparator() {
// 
//            public void prepare(MimeMessage mimeMessage) throws Exception {
//            	
//    			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//    					StandardCharsets.UTF_8.name());
//    			
//    			Context context = new Context();
//    			context.setVariables(mail.getModel());
//    			String html = templateEngine.process(mail.getTemplateName(), context);
//
//    			helper.setTo(mail.getListEmailTo());
//    			helper.setText(html, true);
//    			helper.setSubject(mail.getSubject());
//    			helper.setFrom(emailFrom,"MW Alert");
//    			
//    			if (mail.getListEmailCc() != null) {
//    				helper.setCc(mail.getListEmailCc());
//    			}
//
//    			if (mail.getListEmailBcc() != null) {
//    				helper.setBcc(mail.getListEmailBcc());
//    			}
//            }
//        };
//        
//        return preparator;
//	}
//   
//	@Override
//	public Email defaultSetEmail() {
//	   	log.info("Get default Email Infomation.");
//		Email mail = new Email();
//		List<EmailAddress> emailTo = new ArrayList<>();
//    	for(String item: this.emailTos) {
//			EmailAddress emailAddress = new EmailAddress(item);
//			emailTo.add(emailAddress);
//    	}
//		mail.setEmailTo(emailTo);
//		mail.setSubject(this.subject);
//		Map<String, Object> model = new HashMap<>();
//		model.put("service_name", "Disbursement Service");
//		model.put("impact", "N/A");
//		model.put("exception", "N/A");
//		model.put("issue_date", Utilities.parseDateToString(new Date(),Utilities.PATTERN_TYPE_DATEHOUR));
//		mail.setModel(model);
//		mail.setTemplateName("email");
//		return mail;
//	}
//	
//	@Override
//	@Async("asyncExecutor")
//	public void sendEmail(Object object, ExceptionHandlerMonitoring ehm) {
//		// TODO Auto-generated method stub
//		Date currentDate = new Date();
//		try {
//			Email email = null;
//			MimeMessagePreparator preparator = null;
//			
//			if(object instanceof Email) {
//				email = (Email) object;
//			}else {
//				email = this.defaultSetEmail();
//			}
//			
//			preparator = getMessagePreparator(email);
//			emailSender.send(preparator);
//
//			ehm.setIsSent(true);
//			ehm.setSentDate(currentDate);
//			exceptionHandlerMonitoringRepository.save(ehm);
//			log.info("Send email successed!");
//		} catch (Exception e) {
//			ehm.setIsSent(false);
//			ehm.setSentDate(currentDate);
//			exceptionHandlerMonitoringRepository.save(ehm);
//			log.info("Send email failed: " + e.toString(), e);
//		}
//	}
//}
