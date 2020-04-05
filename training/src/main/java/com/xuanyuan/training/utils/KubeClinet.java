package com.xuanyuan.training.utils;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

/**
 * @ClassName KubeClinet
 * @Desctiption : TODO
 * @Author Lee
 * @Date 2020/4/1 16:20
 */
public class KubeClinet {
    private static KubernetesClient client = null;

    private final static  String KUBECONFIG_FILE = filePath(KubeClinet.class.getResource("/kube/kube-config"));

    public static String filePath(URL path) {
        try {
            return Paths.get(path.toURI()).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public static KubernetesClient getKubeclinet(){
        Config config = null;
        if (config == null) {
            synchronized (KubeClinet.class) {
                System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, KUBECONFIG_FILE);
                config = new ConfigBuilder()
                        // .withMasterUrl("https://192.168.152.132:6443")
                        .build();
            }
        }
        client = new DefaultKubernetesClient(config);
        return client;
    }



    public static void main(String[] args) {
        KubernetesClient kc= KubeClinet.getKubeclinet();
        //获取命名空间
        NamespaceList nameList=kc.namespaces().list();
        List<Namespace> listItems=nameList.getItems();
        for (Namespace item : listItems) {
            System.out.println(item.getMetadata().getName());
        }
        kc.close();
    }
}