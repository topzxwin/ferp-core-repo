package win.topzx.ferp.start;

import com.jfinal.kit.PropKit;
import com.jfinal.server.undertow.UndertowServer;

import io.undertow.UndertowOptions;
import win.topzx.ferp.core.config.FerpConfig;
import win.topzx.ferp.core.kit.FerpPropKit;

/**
 * 启动类
 * @author 天为之殇
 *
 */
public class START {
    public static void main(String[] args) {
    	FerpPropKit.load();//加载配置
    	UndertowServer.create(FerpConfig.class).
    		onStart(builder ->{
    			builder.setServerOption(UndertowOptions.URL_CHARSET, "UTF-8");
    		}).configWeb(builder ->{
    			builder.addWebSocketEndpoint("win.topzx.ferp.core.kit.FSocket");
    		}
    		)
    		.addHotSwapClassPrefix("win.topzx.")
    		.addHotSwapClassPrefix("org.snaker.")
    		.setPort(8888)
    		.setContextPath(PropKit.get("sysContextPath", "/"))
    		.setDevMode(true).start();
    }
}

