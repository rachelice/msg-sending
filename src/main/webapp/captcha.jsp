<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="javax.imageio.ImageIO"%>
<%
    ServletOutputStream os = null;
try
{
    out.clear();
    out = pageContext.pushBody();
    
    //设置页面不缓存
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");

    // 在内存中创建图象
    int width = 100, height = 21;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // 获取图形上下文
    Graphics g = image.getGraphics();

    //生成随机类
    Random random = new Random();

    // 设定背景色
    g.setColor(new Color(200 + random.nextInt(250 - 200), 200 + random.nextInt(250 - 200), 200 + random.nextInt(250 - 200)));
    g.fillRect(0, 0, width, height);

    //设定字体
    g.setFont(new Font("Times New Roman", Font.HANGING_BASELINE, 18));

    //画边框
    g.setColor(new Color(200 + random.nextInt(250 - 200), 200 + random.nextInt(250 - 200), 200 + random.nextInt(250 - 200)));
    g.drawRect(0, 0, width - 1, height - 1);

    // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
    g.setColor(new Color(160 + random.nextInt(200 - 160), 160 + random.nextInt(200 - 160), 160 + random.nextInt(200 - 160)));
    for (int i = 0; i < 155; i++)
    {
	
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(12);
        int yl = random.nextInt(12);
        g.drawLine(x, y, x + xl, y + yl);
    }

    // 取随机产生的认证码(4位数字)
    String sRand = "";
    for (int i = 0; i < 4; i++)
    {
        String rand = String.valueOf(random.nextInt(10));
        sRand += rand;
        // 将认证码显示到图象中
        g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
        g.drawString(rand, 20 * i + 15, 17);
    }

    // 将认证码存入SESSION
    request.getSession().setAttribute("LOGIN_CAPTCHA", sRand);
    
    // 图象生效
    g.dispose();

    // 输出图象到页面
    os = response.getOutputStream();
    ImageIO.write(image, "JPEG", os);
    os.flush();
    out.clear();
    out = pageContext.pushBody();
}
catch(Exception e)
{
}
%>

