# Spring DevOps Lab

> 로컬 환경에서 **GitHub Actions → Docker Hub → Argo CD → Kubernetes → Canary → Auto Scaling → Grafana/Prometheus** 파이프라인을 실습하기 위한 Spring Boot 프로젝트입니다.

---

## 프로젝트 개요

이 프로젝트는 간단한 Spring Boot 앱을 통해 다음과 같은 DevOps 구성 요소를 로컬에서 테스트합니다:

- **CI/CD:** GitHub Actions + Docker Hub
- **CD:** Argo CD (GitOps 방식)
- **Infra:** Kubernetes (Minikube or Kind)
- **Deployment Strategy:** Canary Rollout
- **Scaling:** Horizontal Pod Autoscaler (HPA)
- **Monitoring:** Prometheus + Grafana (Spring Actuator metrics)
- **Application:** 간단한 REST API + 헬스체크 + 버전 구분

---

## 기술 스택

| 구분 | 사용 기술                             |
|------|-----------------------------------|
| Backend | Spring Boot 3.x (Java 21, Gradle) |
| CI/CD | GitHub Actions, Docker Hub        |
| Deployment | Kubernetes (Argo CD)              |
| Monitoring | Prometheus, Grafana               |
| Autoscaling | Kubernetes HPA                    |
| Canary | Argo Rollouts (optional)          |

---

## 목표 아키텍처 요약

```
GitHub Push
  ↓
GitHub Actions (Build + Push)
  ↓
Docker Hub
  ↓
Argo CD (Sync)
  ↓
Kubernetes Cluster
    ├─ Canary Rollout
    ├─ HPA AutoScaling
    └─ Prometheus + Grafana Monitoring

```
