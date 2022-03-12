package com.study.dp.behavioural;

import java.util.ArrayList;
import java.util.List;

interface Channel {
     void update(Object o);
}


class NewsAgency {
    private String news;
    List<Channel> channels = new ArrayList<>();

    public void addObserver(Channel channel) {
        channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for(Channel channel : channels) {
            channel.update(news);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewsAgency{");
        sb.append("news='").append(news).append('\'');
        sb.append(", channels=").append(channels);
        sb.append('}');
        return sb.toString();
    }
}

class NewsChannel implements Channel {

    private String news;

    @Override
    public void update(Object news) {
        this.setNews((String) news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewsChannel{");
        sb.append("news='").append(news).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class Demo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        //Observer
        Channel channel = new NewsChannel();
        Channel channel2 = new NewsChannel();
        Channel channel3 = new NewsChannel();

        //Register obervers to the subject
        agency.addObserver(channel);
        agency.addObserver(channel2);
        agency.addObserver(channel3);

        //
        agency.setNews("News1");

        System.out.println("Agency ::" +agency);
        agency.removeObserver(channel);

        System.out.println("Agency without channel:: " +agency);
    }
}
